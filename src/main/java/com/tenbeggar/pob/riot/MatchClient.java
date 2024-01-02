package com.tenbeggar.pob.riot;

import com.tenbeggar.pob.properties.Continent;
import com.tenbeggar.pob.riot.domain.Match;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Repository
public class MatchClient {

    @Resource
    private RestTemplate restTemplate;

    private static final String MATCHID_BY_CONTINENT_PUUID = "https://{continent}.api.riotgames.com/lol/match/v5/matches/by-puuid/{puuid}/ids?startTime={startTime}&endTime={endTime}&start={start}&count={count}";
    private static final String MATCH_BY_CONTINENT_MATCHID = "https://{continent}.api.riotgames.com/lol/match/v5/matches/{matchId}";
    private static final String MATCH_TIMELINE_BY_CONTINENT_MATCHID = "https://{continent}.api.riotgames.com/lol/match/v5/matches/{matchId}/timeline";

    public List<String> findAllMatchIdByContinentAndPuuid(Continent continent, String puuid, Long startTime, Long endTime, Integer start, Integer count) {
        Object st = startTime;
        if (startTime == null || startTime <= 0) {
            st = "";
        }
        return restTemplate.getForObject(MATCHID_BY_CONTINENT_PUUID, List.class, continent, puuid, st, endTime, start, count);
    }

    public Match findMatchByContinentAndMatchId(Continent continent, String matchId) {
        return restTemplate.getForObject(MATCH_BY_CONTINENT_MATCHID, Match.class, continent, matchId);
    }

    public String findMatchTimelineByContinentAndMatchId(Continent continent, String matchId) {
        return restTemplate.getForObject(MATCH_TIMELINE_BY_CONTINENT_MATCHID, String.class, continent, matchId);
    }
}
