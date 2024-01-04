package com.tenbeggar.pob.service;

import com.tenbeggar.pob.entity.*;
import com.tenbeggar.pob.repository.*;
import com.tenbeggar.pob.riot.DragonClient;
import com.tenbeggar.pob.riot.RiotProperties;
import com.tenbeggar.pob.riot.domain.Champion;
import com.tenbeggar.pob.riot.domain.ChampionMeta;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DragonService {

    private String currentVersion = "";
    private Map<Integer, ChampionEntity> championMap = new HashMap<>();

    @Resource
    private RiotProperties riotProperties;

    @Resource
    private DragonClient dragonClient;

    @Resource
    private ChampionRepository championRepository;
    @Resource
    private ChampionPassiveRepository championPassiveRepository;
    @Resource
    private ChampionSpellRepository championSpellRepository;
    @Resource
    private ChampionStatsRepository championStatsRepository;
    @Resource
    private ChampionSkinRepository championSkinRepository;

    public void setCurrentVersion(String currentVersion) {
        this.currentVersion = currentVersion;
    }

    public String getCurrentVersion() {
        return this.currentVersion;
    }

    public void setChampionMap(String currentVersion) {
        List<ChampionEntity> championEntities = championRepository.findAllByVersionAndLanguage(currentVersion, riotProperties.getLanguage());
        this.championMap = championEntities.stream().collect(Collectors.toMap(ChampionEntity::getId, e -> e));
    }

    public ChampionEntity championById(Integer championId) {
        //防止 ban pick 阶段玩家不选
        if (championId == -1) {
            return ChampionEntity.builder().id(championId).build();
        }
        return championMap.get(championId);
    }

    @Transactional
    public void syncChampion(String version, String language) {
        List<ChampionEntity> championEntities = new ArrayList<>();
        List<ChampionPassiveEntity> championPassiveEntities = new ArrayList<>();
        List<ChampionSpellEntity> championSpellEntities = new ArrayList<>();
        List<ChampionStatsEntity> championStatsEntities = new ArrayList<>();
        List<ChampionSkinEntity> championSkinEntities = new ArrayList<>();
        ChampionMeta champions = dragonClient.champions(version, language);
        champions.getData().forEach((k, v) -> {
            ChampionEntity championEntity = championRepository.findByIdAndVersionAndLanguage(Integer.valueOf(v.getKey()), version, language);
            if (Objects.nonNull(championEntity)) {
                return;
            }
            ChampionMeta championMeta = dragonClient.champion(version, language, k);
            Champion champion = championMeta.getData().get(k);
            championEntity = champion.toEntity(version, language);
            championEntities.add(championEntity);
            Integer championId = championEntity.getId();
            ChampionPassiveEntity championPassiveEntity = champion.getPassive().toEntity(championId, version, language);
            championPassiveEntities.add(championPassiveEntity);
            List<ChampionSpellEntity> championSpellList = champion.getSpells().stream().map(e -> e.toEntity(championId, version, language)).collect(Collectors.toList());
            championSpellEntities.addAll(championSpellList);
            ChampionStatsEntity championStatsEntity = champion.getStats().toEntity(championId, version, language);
            championStatsEntities.add(championStatsEntity);
            List<ChampionSkinEntity> championSkinList = champion.getSkins().stream().map(e -> e.toEntity(championId, version, language)).collect(Collectors.toList());
            championSkinEntities.addAll(championSkinList);
        });
        championRepository.saveAll(championEntities);
        championPassiveRepository.saveAll(championPassiveEntities);
        championSpellRepository.saveAll(championSpellEntities);
        championStatsRepository.saveAll(championStatsEntities);
        championSkinRepository.saveAll(championSkinEntities);
    }

    public String downloadDataDragon(String version) {
        return dragonClient.downloadDataDragon(version, riotProperties.getDragonDir());
    }
}
