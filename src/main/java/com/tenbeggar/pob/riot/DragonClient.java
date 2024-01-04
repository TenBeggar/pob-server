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

    public String downloadDataDragon(String version, String dir) {
        String fileName = String.format("%s-%s", PREFIX_FILE_DRAGON, version);
        Path tgzPath = Paths.get(dir, fileName + SUFFIX_FILE_DRAGON);
        RequestCallback requestCallback = clientHttpRequest -> clientHttpRequest.getHeaders().setAccept(List.of(MediaType.APPLICATION_OCTET_STREAM, MediaType.ALL));
        ResponseExtractor<Boolean> responseExtractor = clientHttpResponse -> {
            try (InputStream inputStream = clientHttpResponse.getBody()) {
                Files.copy(inputStream, tgzPath, StandardCopyOption.REPLACE_EXISTING);
            }
            return true;
        };
        restTemplate.execute(DATA_DRAGON, HttpMethod.GET, requestCallback, responseExtractor, Map.of("version", version));
        String targetFolder = Paths.get(dir, fileName).toString();
        try {
            Extractor.extractTGZ(tgzPath.toString(), targetFolder);
            return targetFolder;
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
