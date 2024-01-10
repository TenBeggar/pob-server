package com.tenbeggar.pob.riot;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tenbeggar.pob.riot.domain.*;
import com.tenbeggar.pob.utils.Extractor;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Collections;
import java.util.List;

@Slf4j
@Repository
public class DragonClient {

    @Resource
    private RiotProperties riotProperties;

    @Resource
    private RestTemplate restTemplate;

    private static final String GAME_MODE = "https://static.developer.riotgames.com/docs/lol/gameModes.json";
    private static final String GAME_TYPE = "https://static.developer.riotgames.com/docs/lol/gameTypes.json";
    private static final String MAP = "https://static.developer.riotgames.com/docs/lol/maps.json";
    private static final String QUEUE = "https://static.developer.riotgames.com/docs/lol/queues.json";

    private static final String VERSION = "https://ddragon.leagueoflegends.com/api/versions.json";

    private static final String DATA_DRAGON = "https://ddragon.leagueoflegends.com/cdn/dragontail-{version}.tgz";
    private static final String PREFIX_FILE_DRAGON = "/dragontail";
    private static final String SUFFIX_FILE_DRAGON = ".tgz";

    private static final String CHAMPION = "https://ddragon.leagueoflegends.com/cdn/{version}/data/{language}/championFull.json";
    private static final String SUMMONER_SPELL = "https://ddragon.leagueoflegends.com/cdn/{version}/data/{language}/summoner.json";
    private static final String ITEM = "https://ddragon.leagueoflegends.com/cdn/{version}/data/{language}/item.json";

    public List<GameMode> allGameMode() {
        ResponseEntity<List<GameMode>> exchange = restTemplate.exchange(GAME_MODE, HttpMethod.GET, null, new ParameterizedTypeReference<>() {
        }, Collections.emptyMap());
        return exchange.getBody();
    }

    public List<GameType> allGameType() {
        ResponseEntity<List<GameType>> exchange = restTemplate.exchange(GAME_TYPE, HttpMethod.GET, null, new ParameterizedTypeReference<>() {
        }, Collections.emptyMap());
        return exchange.getBody();
    }

    public List<Map> allMap() {
        ResponseEntity<List<Map>> exchange = restTemplate.exchange(MAP, HttpMethod.GET, null, new ParameterizedTypeReference<>() {
        }, Collections.emptyMap());
        return exchange.getBody();
    }

    public List<Queue> allQueue() {
        ResponseEntity<List<Queue>> exchange = restTemplate.exchange(QUEUE, HttpMethod.GET, null, new ParameterizedTypeReference<>() {
        }, Collections.emptyMap());
        return exchange.getBody();
    }

    public List<String> allVersion() {
        return restTemplate.getForObject(VERSION, List.class);
    }

    public String downloadDataDragon(String version) {
        File downloadDir = Path.of(System.getProperty("user.dir"), riotProperties.getDragonPath()).toFile();
        if (!downloadDir.exists()) {
            downloadDir.mkdirs();
        }
        log.info("《英雄联盟》资源目录：{}", downloadDir.getAbsolutePath());
        File targetFolder = new File(downloadDir, PREFIX_FILE_DRAGON);
        File versionFolder = new File(targetFolder, version);
        if (versionFolder.exists() && versionFolder.isDirectory()) {
            return targetFolder.getAbsolutePath();
        }
        File tgzFile = new File(downloadDir, PREFIX_FILE_DRAGON + "-" + version + SUFFIX_FILE_DRAGON);
        if (!tgzFile.exists()) {
            ResponseExtractor<Boolean> responseExtractor = clientHttpResponse -> {
                try (InputStream inputStream = clientHttpResponse.getBody()) {
                    Files.copy(inputStream, tgzFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                }
                return true;
            };
            restTemplate.execute(DATA_DRAGON, HttpMethod.GET, null, responseExtractor, java.util.Map.of("version", version));
        }
        try {
            Extractor.extractTGZ(tgzFile, targetFolder);
            return targetFolder.getAbsolutePath();
        } catch (IOException e) {
            throw new RuntimeException("Download DataDragon failed");
        }
    }

    public ChampionData allChampion(String version, String language) {
        File championFile = Path.of(System.getProperty("user.dir"), riotProperties.getDragonPath(), PREFIX_FILE_DRAGON, version, "data", language, "championFull.json").toFile();
        if (championFile.exists()) {
            Gson gson = new Gson();
            try {
                return gson.fromJson(new FileReader(championFile, StandardCharsets.UTF_8), ChampionData.class);
            } catch (IOException e) {
                throw new RuntimeException(championFile.getAbsolutePath() + " loading failed");
            }
        }
        return restTemplate.getForObject(CHAMPION, ChampionData.class, version, language);
    }

    public SummonerSpellData allSummonerSpell(String version, String language) {
        File summonerSpellFile = Path.of(System.getProperty("user.dir"), riotProperties.getDragonPath(), PREFIX_FILE_DRAGON, version, "data", language, "summoner.json").toFile();
        if (summonerSpellFile.exists()) {
            Gson gson = new Gson();
            try {
                return gson.fromJson(new FileReader(summonerSpellFile, StandardCharsets.UTF_8), SummonerSpellData.class);
            } catch (IOException e) {
                throw new RuntimeException(summonerSpellFile.getAbsolutePath() + " loading failed");
            }
        }
        return restTemplate.getForObject(SUMMONER_SPELL, SummonerSpellData.class, version, language);
    }

    public ItemData allItem(String version, String language) {
        File itemFile = Path.of(System.getProperty("user.dir"), riotProperties.getDragonPath(), PREFIX_FILE_DRAGON, version, "data", language, "item.json").toFile();
        if (itemFile.exists()) {
            Gson gson = new Gson();
            try {
                return gson.fromJson(new FileReader(itemFile, StandardCharsets.UTF_8), ItemData.class);
            } catch (IOException e) {
                throw new RuntimeException(itemFile.getAbsolutePath() + " loading failed");
            }
        }
        return restTemplate.getForObject(ITEM, ItemData.class, version, language);
    }

    public List<Perk> allPerk(String version, String language) {
        File perkFile = Path.of(System.getProperty("user.dir"), riotProperties.getDragonPath(), PREFIX_FILE_DRAGON, version, "data", language, "runesReforged.json").toFile();
        if (!perkFile.exists()) {
            throw new RuntimeException(perkFile.getAbsolutePath() + " not found");
        }
        Gson gson = new Gson();
        try {
            return gson.fromJson(new FileReader(perkFile, StandardCharsets.UTF_8), new TypeToken<List<Perk>>() {
            }.getType());
        } catch (IOException e) {
            throw new RuntimeException(perkFile.getAbsolutePath() + " loading failed");
        }
    }
}
