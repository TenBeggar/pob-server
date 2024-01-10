package com.tenbeggar.pob.service;

import com.tenbeggar.pob.controller.vo.*;
import com.tenbeggar.pob.entity.*;
import com.tenbeggar.pob.enums.ObjectiveTypeEnum;
import com.tenbeggar.pob.enums.ParticipantPerkEnum;
import com.tenbeggar.pob.enums.RegionEnum;
import com.tenbeggar.pob.repository.*;
import com.tenbeggar.pob.riot.MatchClient;
import com.tenbeggar.pob.riot.domain.*;
import com.tenbeggar.pob.utils.PageVO;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MatchService {

    @Resource
    private MatchClient matchClient;

    @Resource
    private MatchTaskBillboardService matchTaskBillboardService;
    @Resource
    private DragonService dragonService;

    @Resource
    private SummonerRepository summonerRepository;
    @Resource
    private SummonerMatchRepository summonerMatchRepository;
    @Resource
    private MatchRepository matchRepository;
    @Resource
    private ParticipantRepository participantRepository;
    @Resource
    private ParticipantPerkRepository participantPerkRepository;
    @Resource
    private TeamRepository teamRepository;
    @Resource
    private BanRepository banRepository;
    @Resource
    private ObjectiveRepository objectiveRepository;

    public PageVO<MatchVO> pageBySummonerPobId(String summonerPobId, Integer current, Integer size) {
        Optional<SummonerEntity> optional = summonerRepository.findById(summonerPobId);
        SummonerEntity summonerEntity = optional.orElseThrow(() -> new RuntimeException("Summoner not found"));
        matchTaskBillboardService.postMatchTask(RegionEnum.toContinent(summonerEntity.getRegion()).name(), summonerEntity.getPuuid());
        Pageable pageable = PageRequest.of(current, size, Sort.by("matchId").descending());
        Page<SummonerMatchEntity> summonerMatchPage = summonerMatchRepository.findAllByPuuid(summonerEntity.getPuuid(), pageable);
        List<String> matchIds = summonerMatchPage.get().map(SummonerMatchEntity::getMatchId).collect(Collectors.toList());
        List<MatchEntity> matchEntities = matchRepository.findAllByMatchIdIn(matchIds);
        List<MatchVO> matchVOs = matchEntities.stream().map(this::entity2VO).collect(Collectors.toList());
        return PageVO.build(matchVOs, summonerMatchPage.getTotalElements());
    }

    private MatchVO entity2VO(MatchEntity matchEntity) {
        MatchVO matchVO = new MatchVO();
        BeanUtils.copyProperties(matchEntity, matchVO);
        List<ParticipantEntity> participantEntities = participantRepository.findAllByMatchId(matchVO.getMatchId());
        List<ParticipantVO> participants = participantEntities.stream().map(e -> {
            ParticipantVO participantVO = new ParticipantVO();
            BeanUtils.copyProperties(e, participantVO);
            ChampionEntity championEntity = dragonService.championById(participantVO.getChampionId());
            participantVO.setChampionIcon(championEntity.getImage());
            SummonerSpellEntity summoner1Spell = dragonService.summonerSpellById(participantVO.getSummoner1Id());
            participantVO.setSummoner1Icon(summoner1Spell.getImage());
            SummonerSpellEntity summoner2Spell = dragonService.summonerSpellById(participantVO.getSummoner2Id());
            participantVO.setSummoner2Icon(summoner2Spell.getImage());
            List<ParticipantPerkEntity> participantPerkEntities = participantPerkRepository.findAllByMatchIdAndParticipantId(e.getMatchId(), e.getParticipantId());
            participantVO.setPerks(ParticipantPerkEnum.toVO(participantPerkEntities));
            return participantVO;
        }).collect(Collectors.toList());
        List<TeamEntity> teamEntities = teamRepository.findAllByMatchId(matchVO.getMatchId());
        List<TeamVO> teams = teamEntities.stream().map(e -> {
            TeamVO teamVO = new TeamVO();
            BeanUtils.copyProperties(e, teamVO);
            List<BanEntity> banEntities = banRepository.findAllByMatchIdAndTeamId(e.getMatchId(), teamVO.getTeamId());
            List<BanVO> bans = banEntities.stream().map(a -> {
                BanVO banVO = new BanVO();
                BeanUtils.copyProperties(a, banVO);
                ChampionEntity championEntity = dragonService.championById(banVO.getChampionId());
                banVO.setChampionIcon(championEntity.getImage());
                return banVO;
            }).collect(Collectors.toList());
            List<ObjectiveEntity> objectiveEntities = objectiveRepository.findAllByMatchIdAndTeamId(e.getMatchId(), teamVO.getTeamId());
            List<ObjectiveVO> objectives = objectiveEntities.stream().map(a -> {
                ObjectiveVO objectiveVO = new ObjectiveVO();
                BeanUtils.copyProperties(a, objectiveVO);
                return objectiveVO;
            }).collect(Collectors.toList());
            teamVO.setBans(bans);
            teamVO.setObjectives(objectives);
            return teamVO;
        }).collect(Collectors.toList());
        matchVO.setParticipants(participants);
        matchVO.setTeams(teams);
        return matchVO;
    }

    @Transactional
    public void saveAllByContinentAndMatchIds(String continent, List<String> matchIds) {
        List<MatchEntity> matchEntities = new ArrayList<>();
        List<ParticipantEntity> participantEntities = new ArrayList<>();
        List<ParticipantPerkEntity> participantPerkEntities = new ArrayList<>();
        List<TeamEntity> teamEntities = new ArrayList<>();
        List<BanEntity> banEntities = new ArrayList<>();
        List<ObjectiveEntity> objectiveEntities = new ArrayList<>();
        matchIds.forEach(e -> {
            MatchEntity entity = matchRepository.findByMatchId(e);
            if (Objects.nonNull(entity)) {
                return;
            }
            //对局
            Match match = matchClient.findMatchByContinentAndMatchId(continent, e);
            MatchInfo matchInfo = match.getInfo();
            MatchEntity matchEntity = matchInfo.toEntity(match.getMetadata());
            matchEntities.add(matchEntity);
            //参与者
            List<ParticipantEntity> participantEntityList = matchInfo.getParticipants().stream().map(a -> {
                ParticipantEntity participantEntity = a.toEntity(matchEntity);
                //符文选择
                ParticipantPerk perks = a.getPerks();
                if (Objects.nonNull(perks)) {
                    List<ParticipantPerkEntity> participantPerkEntityList = perks.toEntity(participantEntity);
                    participantPerkEntities.addAll(participantPerkEntityList);
                }
                return participantEntity;
            }).collect(Collectors.toList());
            participantEntities.addAll(participantEntityList);
            //队伍
            matchInfo.getTeams().forEach(a -> {
                TeamEntity teamEntity = a.toEntity(matchEntity);
                teamEntities.add(teamEntity);
                //禁用英雄
                List<Ban> bans = a.getBans();
                if (!CollectionUtils.isEmpty(bans)) {
                    List<BanEntity> banEntityList = bans.stream().map(o -> o.toEntity(teamEntity)).collect(Collectors.toList());
                    banEntities.addAll(banEntityList);
                }
                //击杀目标
                Objectives objectives = a.getObjectives();
                if (Objects.nonNull(objectives)) {
                    List<ObjectiveEntity> objectiveEntityList = ObjectiveTypeEnum.objectivesToEntities(objectives, teamEntity);
                    objectiveEntities.addAll(objectiveEntityList);
                }
            });
        });
        matchRepository.saveAll(matchEntities);
        participantRepository.saveAll(participantEntities);
        participantPerkRepository.saveAll(participantPerkEntities);
        teamRepository.saveAll(teamEntities);
        banRepository.saveAll(banEntities);
        objectiveRepository.saveAll(objectiveEntities);
    }

    public List<ChampionRateVO> useChampion(String summonerPobId, Integer top) {
        Optional<SummonerEntity> optional = summonerRepository.findById(summonerPobId);
        SummonerEntity summonerEntity = optional.orElseThrow(() -> new RuntimeException("Summoner not found"));
        return participantRepository.useChampion(summonerEntity.getPuuid(), top);
    }

    public List<ChampionRateVO> winChampion(String summonerPobId, Integer top) {
        Optional<SummonerEntity> optional = summonerRepository.findById(summonerPobId);
        SummonerEntity summonerEntity = optional.orElseThrow(() -> new RuntimeException("Summoner not found"));
        return participantRepository.winChampion(summonerEntity.getPuuid(), top);
    }
}
