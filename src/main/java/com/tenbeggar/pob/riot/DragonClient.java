package com.tenbeggar.pob.riot;

import com.tenbeggar.pob.riot.domain.ChampionMeta;
import com.tenbeggar.pob.utils.Extractor;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Map;

@Slf4j
@Repository
public class DragonClient {

    @Resource
    private RestTemplate restTemplate;

    private static final String PREFIX_FILE_DRAGON = "/dragontail";
    private static final String SUFFIX_FILE_DRAGON = ".tgz";

    private static final String ALL_VERSIONS = "https://ddragon.leagueoflegends.com/api/versions.json";
    private static final String DATA_DRAGON = "https://ddragon.leagueoflegends.com/cdn/dragontail-{version}.tgz";

    private static final String ALL_CHAMPION = "https://ddragon.leagueoflegends.com/cdn/{version}/data/{languageCode}/champion.json";
    private static final String CHAMPION_INFO = "https://ddragon.leagueoflegends.com/cdn/{version}/data/{languageCode}/champion/{championName}.json";

    public List<String> allVersions() {
        return restTemplate.getForObject(ALL_VERSIONS, List.class);
    }

    public String downloadDataDragon(String version, String url) {
        File downloadDir = new File(url);
        if (!downloadDir.exists()) {
            downloadDir.mkdirs();
        }
        log.info("《英雄联盟》资源目录：{}", downloadDir.getAbsolutePath());
        String targetName = String.format("%s-%s", PREFIX_FILE_DRAGON, version);
        File targetFolder = new File(downloadDir, targetName);
        if (targetFolder.exists() && targetFolder.isDirectory()) {
            return targetFolder.getAbsolutePath();
        }
        Path tgzPath = Paths.get(url, targetName + SUFFIX_FILE_DRAGON);
        File tgzFile = tgzPath.toFile();
        if (!tgzFile.exists()) {
            RequestCallback requestCallback = clientHttpRequest -> clientHttpRequest.getHeaders().setAccept(List.of(MediaType.APPLICATION_OCTET_STREAM, MediaType.ALL));
            ResponseExtractor<Boolean> responseExtractor = clientHttpResponse -> {
                try (InputStream inputStream = clientHttpResponse.getBody()) {
                    Files.copy(inputStream, tgzPath, StandardCopyOption.REPLACE_EXISTING);
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

    public ChampionMeta champions(String version, String language) {
        return restTemplate.getForObject(ALL_CHAMPION, ChampionMeta.class, version, language);
    }

    public ChampionMeta champion(String version, String language, String enId) {
        return restTemplate.getForObject(CHAMPION_INFO, ChampionMeta.class, version, language, enId);
    }
}
