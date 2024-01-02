package com.tenbeggar.pob.riot;

import com.tenbeggar.pob.properties.RiotProperties;
import jakarta.annotation.Resource;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

@Repository
public class DragonClient {

    @Resource
    private RestTemplate restTemplate;
    @Resource
    private RiotProperties riotProperties;

    private static final String DATA_DRAGON = "https://ddragon.leagueoflegends.com/cdn/dragontail-{version}.tgz";
    private static final String HISTORY_VERSIONS = "https://ddragon.leagueoflegends.com/api/versions.json";

    public String latestVersion() {
        List<String> versions = restTemplate.getForObject(HISTORY_VERSIONS, List.class);
        return versions.get(0);
    }

    public void downloadDataDragon(String version) {
        String path = riotProperties.getDataDragon();
        RequestCallback requestCallback = clientHttpRequest -> clientHttpRequest.getHeaders().setAccept(List.of(MediaType.APPLICATION_OCTET_STREAM, MediaType.ALL));
        ResponseExtractor<Boolean> responseExtractor = clientHttpResponse -> {
            Files.copy(clientHttpResponse.getBody(), Paths.get(path + "/dragontail.tgz"));
            return true;
        };
        Boolean execute = restTemplate.execute(DATA_DRAGON, HttpMethod.GET, requestCallback, responseExtractor, Map.of("version", version));
        System.out.println(execute);
        if (execute == null || !execute) {
            return;
        }
        //TODO解压
    }
}
