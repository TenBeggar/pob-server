package com.tenbeggar.pob.riot;

import com.tenbeggar.pob.properties.Region;
import com.tenbeggar.pob.riot.domain.Summoner;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class SummonerClient {

    @Resource
    private RestTemplate restTemplate;

    private static final String SUMMONER_BY_REGION_NAME = "https://{region}.api.riotgames.com/lol/summoner/v4/summoners/by-name/{summonerName}";
    private static final String SUMMONER_BY_REGION_PUUID = "https://{region}.api.riotgames.com/lol/summoner/v4/summoners/by-puuid/{encryptedPUUID}";


    public Summoner findByRegionAndName(String region, String name) {
        return restTemplate.getForObject(SUMMONER_BY_REGION_NAME, Summoner.class, region, name);
    }

    public Summoner findByRegionAndPuuid(Region region, String puuid) {
        return restTemplate.getForObject(SUMMONER_BY_REGION_PUUID, Summoner.class, region, puuid);
    }
}
