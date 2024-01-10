package com.tenbeggar.pob.service;

import com.tenbeggar.pob.controller.vo.GameModeVO;
import com.tenbeggar.pob.controller.vo.GameTypeVO;
import com.tenbeggar.pob.controller.vo.MapVO;
import com.tenbeggar.pob.controller.vo.QueueVO;
import com.tenbeggar.pob.entity.*;
import com.tenbeggar.pob.repository.*;
import com.tenbeggar.pob.riot.DragonClient;
import com.tenbeggar.pob.riot.RiotProperties;
import com.tenbeggar.pob.riot.domain.*;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class DragonService {

    private String currentVersion = "";
    private Map<Integer, ChampionEntity> championMap = new HashMap<>();
    private Map<Integer, SummonerSpellEntity> summonerSpellMap = new HashMap<>();
    private Map<Integer, PerkEntity> perkMap = new HashMap<>();
    private Map<Integer, ItemEntity> itemMap = new HashMap<>();

    @Resource
    private RiotProperties riotProperties;

    @Resource
    private DragonClient dragonClient;

    @Resource
    private GameModeRepository gameModeRepository;
    @Resource
    private GameTypeRepository gameTypeRepository;
    @Resource
    private MapRepository mapRepository;
    @Resource
    private QueueRepository queueRepository;
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
    @Resource
    private SummonerSpellRepository summonerSpellRepository;
    @Resource
    private PerkRepository perkRepository;
    @Resource
    private ItemRepository itemRepository;

    public void setCurrentVersion(String currentVersion) {
        this.currentVersion = currentVersion;
    }

    public void setChampionMap(String currentVersion) {
        List<ChampionEntity> championEntities = championRepository.findAllByVersionAndLanguage(currentVersion, riotProperties.getLanguage());
        this.championMap = championEntities.stream().collect(Collectors.toMap(ChampionEntity::getId, e -> e));
    }

    public void setSummonerSpellMap(String currentVersion) {
        List<SummonerSpellEntity> summonerSpellEntities = summonerSpellRepository.findAllByVersionAndLanguage(currentVersion, riotProperties.getLanguage());
        this.summonerSpellMap = summonerSpellEntities.stream().collect(Collectors.toMap(SummonerSpellEntity::getId, e -> e));
    }

    public void setPerkMap(String currentVersion) {
        List<PerkEntity> perkEntities = perkRepository.findAllByVersionAndLanguage(currentVersion, riotProperties.getLanguage());
        this.perkMap = perkEntities.stream().collect(Collectors.toMap(PerkEntity::getId, e -> e));
    }

    public void setItemMap(String currentVersion) {
        List<ItemEntity> itemEntities = itemRepository.findAllByVersionAndLanguage(currentVersion, riotProperties.getLanguage());
        this.itemMap = itemEntities.stream().collect(Collectors.toMap(ItemEntity::getId, e -> e));
    }

    public String getCurrentVersion() {
        return this.currentVersion;
    }

    public ChampionEntity championById(Integer championId) {
        //防止 Ban Pick 阶段玩家不选
        if (championId == -1) {
            return ChampionEntity.builder().id(championId).build();
        }
        return championMap.get(championId);
    }

    public SummonerSpellEntity summonerSpellById(Integer summonerSpellId) {
        return summonerSpellMap.get(summonerSpellId);
    }

    public PerkEntity perkById(Integer perkId) {
        return perkMap.get(perkId);
    }

    public ItemEntity itemById(Integer itemId) {
        return itemMap.get(itemId);
    }

    public List<GameModeVO> allGameMode() {
        List<GameModeEntity> gameModeEntities = gameModeRepository.findAll();
        return gameModeEntities.stream().map(e -> {
            GameModeVO gameModeVO = new GameModeVO();
            BeanUtils.copyProperties(e, gameModeVO);
            return gameModeVO;
        }).collect(Collectors.toList());
    }

    public List<GameTypeVO> allGameType() {
        List<GameTypeEntity> gameTypeEntities = gameTypeRepository.findAll();
        return gameTypeEntities.stream().map(e -> {
            GameTypeVO gameTypeVO = new GameTypeVO();
            BeanUtils.copyProperties(e, gameTypeVO);
            return gameTypeVO;
        }).collect(Collectors.toList());
    }

    public List<MapVO> allMap() {
        List<MapEntity> mapEntities = mapRepository.findAll();
        return mapEntities.stream().map(e -> {
            MapVO mapVO = new MapVO();
            BeanUtils.copyProperties(e, mapVO);
            return mapVO;
        }).collect(Collectors.toList());
    }

    public List<QueueVO> allQueue() {
        List<QueueEntity> queueEntities = queueRepository.findAll();
        return queueEntities.stream().map(e -> {
            QueueVO queueVO = new QueueVO();
            BeanUtils.copyProperties(e, queueVO);
            return queueVO;
        }).collect(Collectors.toList());
    }

    @Transactional
    public void syncDoc() {
        List<GameMode> gameModes = dragonClient.allGameMode();
        List<GameModeEntity> gameModeEntities = gameModes.stream().map(e -> {
            GameModeEntity gameModeEntity = new GameModeEntity();
            BeanUtils.copyProperties(e, gameModeEntity);
            return gameModeEntity;
        }).collect(Collectors.toList());
        gameModeRepository.saveAll(gameModeEntities);
        List<GameType> gameTypes = dragonClient.allGameType();
        List<GameTypeEntity> gameTypeEntities = gameTypes.stream().map(e -> {
            GameTypeEntity gameTypeEntity = new GameTypeEntity();
            BeanUtils.copyProperties(e, gameTypeEntity);
            return gameTypeEntity;
        }).collect(Collectors.toList());
        gameTypeRepository.saveAll(gameTypeEntities);
        List<com.tenbeggar.pob.riot.domain.Map> maps = dragonClient.allMap();
        List<MapEntity> mapEntities = maps.stream().map(e -> {
            MapEntity mapEntity = new MapEntity();
            BeanUtils.copyProperties(e, mapEntity);
            return mapEntity;
        }).collect(Collectors.toList());
        mapRepository.saveAll(mapEntities);
        List<com.tenbeggar.pob.riot.domain.Queue> queues = dragonClient.allQueue();
        List<QueueEntity> queueEntities = queues.stream().map(e -> {
            QueueEntity queueEntity = new QueueEntity();
            BeanUtils.copyProperties(e, queueEntity);
            return queueEntity;
        }).collect(Collectors.toList());
        queueRepository.saveAll(queueEntities);
    }

    @Transactional
    public void syncChampion(String version, String language) {
        List<ChampionEntity> championEntities = new ArrayList<>();
        List<ChampionPassiveEntity> championPassiveEntities = new ArrayList<>();
        List<ChampionSpellEntity> championSpellEntities = new ArrayList<>();
        List<ChampionStatsEntity> championStatsEntities = new ArrayList<>();
        List<ChampionSkinEntity> championSkinEntities = new ArrayList<>();
        ChampionData champions = dragonClient.allChampion(version, language);
        champions.getData().forEach((k, v) -> {
            ChampionEntity championEntity = championRepository.findByIdAndVersionAndLanguage(Integer.valueOf(v.getKey()), version, language);
            if (Objects.nonNull(championEntity)) {
                return;
            }
            championEntity = v.toEntity(version, language);
            championEntities.add(championEntity);
            Integer championId = championEntity.getId();
            ChampionPassiveEntity championPassiveEntity = v.getPassive().toEntity(championId, version, language);
            championPassiveEntities.add(championPassiveEntity);
            List<ChampionSpellEntity> championSpellList = v.getSpells().stream().map(e -> e.toEntity(championId, version, language)).collect(Collectors.toList());
            championSpellEntities.addAll(championSpellList);
            ChampionStatsEntity championStatsEntity = v.getStats().toEntity(championId, version, language);
            championStatsEntities.add(championStatsEntity);
            List<ChampionSkinEntity> championSkinList = v.getSkins().stream().map(e -> e.toEntity(championId, version, language)).collect(Collectors.toList());
            championSkinEntities.addAll(championSkinList);
        });
        championRepository.saveAll(championEntities);
        championPassiveRepository.saveAll(championPassiveEntities);
        championSpellRepository.saveAll(championSpellEntities);
        championStatsRepository.saveAll(championStatsEntities);
        championSkinRepository.saveAll(championSkinEntities);
    }

    @Transactional
    public void syncSummonerSpell(String version, String language) {
        List<SummonerSpellEntity> summonerSpellEntities = new ArrayList<>();
        SummonerSpellData summonerSpellData = dragonClient.allSummonerSpell(version, language);
        summonerSpellData.getData().forEach((k, v) -> {
            SummonerSpellEntity summonerSpellEntity = summonerSpellRepository.findByIdAndVersionAndLanguage(Integer.valueOf(v.getKey()), version, language);
            if (Objects.nonNull(summonerSpellEntity)) {
                return;
            }
            summonerSpellEntity = v.toEntity(version, language);
            summonerSpellEntities.add(summonerSpellEntity);
        });
        summonerSpellRepository.saveAll(summonerSpellEntities);
    }

    @Transactional
    public void syncPerk(String version, String language) {
        List<Perk> perks = dragonClient.allPerk(version, language);
        List<PerkEntity> perkEntities = perks.stream().map(e -> e.toEntity(version, language)).flatMap(List::stream).collect(Collectors.toList());
        perkRepository.saveAll(perkEntities);
    }

    @Transactional
    public void syncItem(String version, String language) {
        ItemData itemData = dragonClient.allItem(version, language);
        List<ItemEntity> itemEntities = new ArrayList<>();
        itemData.getData().forEach((k, v) -> {
            ItemEntity itemEntity = v.toEntity(Integer.valueOf(k), version, language);
            itemEntities.add(itemEntity);
        });
        itemRepository.saveAll(itemEntities);
    }

    @Transactional
    public void syncData(String version) {
        String language = riotProperties.getLanguage();
        this.syncChampion(version, language);
        this.syncSummonerSpell(version, language);
        this.syncPerk(version, language);
        this.syncItem(version, language);
    }

    public void setData(String version) {
        this.setCurrentVersion(version);
        this.setChampionMap(version);
        this.setSummonerSpellMap(version);
        this.setPerkMap(version);
        this.setItemMap(version);
    }

    public String downloadDataDragon(String version) {
        return dragonClient.downloadDataDragon(version);
    }
}
