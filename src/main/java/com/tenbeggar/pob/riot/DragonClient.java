package com.tenbeggar.pob.riot;

import com.google.gson.Gson;
import com.tenbeggar.pob.riot.domain.ChampionData;
import com.tenbeggar.pob.riot.domain.SummonerSpellData;
import com.tenbeggar.pob.utils.Extractor;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Map;

@Slf4j
@Repository
public class DragonClient {

    @Resource
    private RiotProperties riotProperties;

    @Resource
    private RestTemplate restTemplate;

    private static final String PREFIX_FILE_DRAGON = "/dragontail";
    private static final String SUFFIX_FILE_DRAGON = ".tgz";

    private static final String ALL_VERSIONS = "https://ddragon.leagueoflegends.com/api/versions.json";
    private static final String DATA_DRAGON = "https://ddragon.leagueoflegends.com/cdn/dragontail-{version}.tgz";

    private static final String ALL_CHAMPION = "https://ddragon.leagueoflegends.com/cdn/{version}/data/{language}/champion.json";
    private static final String CHAMPION_INFO = "https://ddragon.leagueoflegends.com/cdn/{version}/data/{language}/champion/{championENId}.json";

    private static final String ALL_SUMMONER_SPELLS = "https://ddragon.leagueoflegends.com/cdn/{version}/data/{language}/summoner.json";

    public List<String> allVersions() {
        return restTemplate.getForObject(ALL_VERSIONS, List.class);
    }

    public String downloadDataDragon(String version) {
        File downloadDir = Path.of(System.getProperty("user.dir"), riotProperties.getDragonPath()).toFile();
        if (!downloadDir.exists()) {
            downloadDir.mkdirs();
        }
        log.info("《英雄联盟》资源目录：{}", downloadDir.getAbsolutePath());
        File targetFolder = new File(downloadDir, PREFIX_FILE_DRAGON);
        if (targetFolder.exists() && targetFolder.isDirectory()) {
            return targetFolder.getAbsolutePath();
        }
        File tgzFile = new File(downloadDir, PREFIX_FILE_DRAGON + SUFFIX_FILE_DRAGON);
        if (!tgzFile.exists()) {
            RequestCallback requestCallback = clientHttpRequest -> clientHttpRequest.getHeaders().setAccept(List.of(MediaType.APPLICATION_OCTET_STREAM, MediaType.ALL));
            ResponseExtractor<Boolean> responseExtractor = clientHttpResponse -> {
                try (InputStream inputStream = clientHttpResponse.getBody()) {
                    Files.copy(inputStream, tgzFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                }
                return true;
            };
            restTemplate.execute(DATA_DRAGON, HttpMethod.GET, requestCallback, responseExtractor, Map.of("version", version));
        }
        try {
            Extractor.extractTGZ(tgzFile, targetFolder);
            return targetFolder.getAbsolutePath();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public ChampionData allChampions(String version, String language) {
        File championFile = Path.of(System.getProperty("user.dir"), riotProperties.getDragonPath(), PREFIX_FILE_DRAGON, version, "data", language, "champion.json").toFile();
        if (championFile.exists()) {
            Gson gson = new Gson();
            try {
                return gson.fromJson(new FileReader(championFile), ChampionData.class);
            } catch (IOException e) {
                throw new RuntimeException(championFile.getAbsolutePath() + " deserialization error");
            }
        }
        return restTemplate.getForObject(ALL_CHAMPION, ChampionData.class, version, language);
    }

    public ChampionData champion(String version, String language, String enId) {
        File championFile = Path.of(System.getProperty("user.dir"), riotProperties.getDragonPath(), PREFIX_FILE_DRAGON, version, "data", language, "champion", enId + ".json").toFile();
        if (championFile.exists()) {
            Gson gson = new Gson();
            try {
                return gson.fromJson(new FileReader(championFile), ChampionData.class);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(championFile.getAbsolutePath() + " deserialization error");
            }
        }
        return restTemplate.getForObject(CHAMPION_INFO, ChampionData.class, version, language, enId);
    }

    public SummonerSpellData allSummonerSpells(String version, String language) {
        File summonerSpellFile = Path.of(System.getProperty("user.dir"), riotProperties.getDragonPath(), PREFIX_FILE_DRAGON, version, "data", language, "summoner.json").toFile();
        if (summonerSpellFile.exists()) {
            Gson gson = new Gson();
            try {
                return gson.fromJson(new FileReader(summonerSpellFile), SummonerSpellData.class);
            } catch (IOException e) {
                throw new RuntimeException(summonerSpellFile.getAbsolutePath() + "deserialization error");
            }
        }
        return restTemplate.getForObject(ALL_SUMMONER_SPELLS, SummonerSpellData.class, version, language);
    }
}
