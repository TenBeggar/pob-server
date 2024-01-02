package com.tenbeggar.pob.service;

import com.tenbeggar.pob.controller.vo.MatchVO;
import com.tenbeggar.pob.entity.*;
import com.tenbeggar.pob.properties.Continent;
import com.tenbeggar.pob.properties.ObjectiveType;
import com.tenbeggar.pob.repository.*;
import com.tenbeggar.pob.riot.MatchClient;
import com.tenbeggar.pob.riot.domain.Match;
import com.tenbeggar.pob.riot.domain.MatchInfo;
import com.tenbeggar.pob.utils.PageVO;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MatchService {

    @Resource
    private MatchClient matchClient;

    @Resource
    private MatchTaskBillboardService matchTaskBillboardService;

    @Resource
    private SummonerRepository summonerRepository;
    @Resource
    private SummonerMatchRepository summonerMatchRepository;
    @Resource
    private MatchRepository matchRepository;
    @Resource
    private ParticipantRepository participantRepository;
    @Resource
    private TeamRepository teamRepository;
    @Resource
    private BanRepository banRepository;
    @Resource
    private ObjectiveRepository objectiveRepository;

    public PageVO<MatchVO> pageBySummonerPobId(String summonerPobId, Integer current, Integer size) {
        Optional<SummonerEntity> optional = summonerRepository.findById(summonerPobId);
        SummonerEntity summonerEntity = optional.orElseThrow(() -> new RuntimeException("当前用户不存在"));
        matchTaskBillboardService.postMatchTask(summonerEntity.getRegion().toContinent(), summonerEntity.getPuuid());
        Pageable pageable = PageRequest.of(current, size, Sort.by("matchId").descending());
        Page<SummonerMatchEntity> summonerMatchPage = summonerMatchRepository.findAllByPuuid(summonerEntity.getPuuid(), pageable);
        List<String> matchIds = summonerMatchPage.get().map(SummonerMatchEntity::getMatchId).collect(Collectors.toList());
        List<MatchEntity> matchEntities = matchRepository.findAllByMatchIdIn(matchIds);
        return PageVO.build(matchEntities, MatchVO.class, summonerMatchPage.getTotalElements());
    }

    @Transactional
    public void saveAllByContinentAndMatchIds(Continent continent, List<String> matchIds) {
        List<MatchEntity> matchInfoEntities = new ArrayList<>();
        List<ParticipantEntity> participantEntities = new ArrayList<>();
        List<TeamEntity> teamEntities = new ArrayList<>();
        List<BanEntity> banEntities = new ArrayList<>();
        List<ObjectiveEntity> objectiveEntities = new ArrayList<>();
        matchIds.forEach(e -> {
            Match match = matchClient.findMatchByContinentAndMatchId(continent, e);
            MatchInfo matchInfo = match.getInfo();
            MatchEntity matchEntity = new MatchEntity();
            BeanUtils.copyProperties(match.getInfo(), matchEntity);
            matchEntity.fill(match.getMetadata());
            matchInfoEntities.add(matchEntity);
            List<ParticipantEntity> participantEntityList = matchInfo.getParticipants().stream().map(a -> {
                ParticipantEntity participantEntity = new ParticipantEntity();
                BeanUtils.copyProperties(a, participantEntity);
                participantEntity.fill(matchEntity);
                return participantEntity;
            }).collect(Collectors.toList());
            participantEntities.addAll(participantEntityList);
            matchInfo.getTeams().forEach(a -> {
                TeamEntity teamEntity = new TeamEntity();
                BeanUtils.copyProperties(a, teamEntity);
                teamEntity.fill(matchEntity);
                teamEntities.add(teamEntity);
                List<BanEntity> banEntityList = a.getBans().stream().map(o -> {
                    BanEntity banEntity = new BanEntity();
                    BeanUtils.copyProperties(o, banEntity);
                    banEntity.fill(teamEntity);
                    return banEntity;
                }).collect(Collectors.toList());
                banEntities.addAll(banEntityList);
                List<ObjectiveEntity> objectiveEntityList = ObjectiveType.objectivesToEntities(a.getObjectives(), teamEntity);
                objectiveEntities.addAll(objectiveEntityList);
            });
        });
        matchRepository.saveAll(matchInfoEntities);
        participantRepository.saveAll(participantEntities);
        teamRepository.saveAll(teamEntities);
        banRepository.saveAll(banEntities);
        objectiveRepository.saveAll(objectiveEntities);
    }
}
