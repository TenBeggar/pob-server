package com.tenbeggar.pob.service;

import com.tenbeggar.pob.controller.vo.SummonerVO;
import com.tenbeggar.pob.entity.SummonerEntity;
import com.tenbeggar.pob.repository.SummonerRepository;
import com.tenbeggar.pob.riot.SummonerClient;
import com.tenbeggar.pob.riot.domain.Summoner;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class SummonerService {

    @Resource
    private SummonerRepository summonerRepository;
    @Resource
    private SummonerClient summonerClient;

    public SummonerVO findByRegionAndName(String region, String name) {
        SummonerEntity summonerEntity = summonerRepository.findByRegionAndName(region, name);
        if (Objects.isNull(summonerEntity)) {
            Summoner summoner = summonerClient.findByRegionAndName(region, name);
            summonerEntity = new SummonerEntity();
            BeanUtils.copyProperties(summoner, summonerEntity);
            summonerEntity.setRegion(region);
            summonerEntity = summonerRepository.save(summonerEntity);
        }
        SummonerVO summonerVO = new SummonerVO();
        BeanUtils.copyProperties(summonerEntity, summonerVO);
        return summonerVO;
    }

    public SummonerVO refreshByPobId(String pobId) {
        Optional<SummonerEntity> optional = summonerRepository.findById(pobId);
        SummonerEntity summonerEntity = optional.orElseThrow(() -> new RuntimeException("当前用户不存在"));
        Summoner summoner = summonerClient.findByRegionAndPuuid(summonerEntity.getRegion(), summonerEntity.getPuuid());
        summonerEntity.setName(summoner.getName());
        summonerEntity.setProfileIconId(summoner.getProfileIconId());
        summonerEntity.setRevisionDate(summoner.getRevisionDate());
        summonerEntity.setSummonerLevel(summoner.getSummonerLevel());
        summonerRepository.save(summonerEntity);
        SummonerVO summonerVO = new SummonerVO();
        BeanUtils.copyProperties(summonerEntity, summonerVO);
        return summonerVO;
    }
}
