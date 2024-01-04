package com.tenbeggar.pob.riot;

import com.tenbeggar.pob.entity.SummonerMatchEntity;
import com.tenbeggar.pob.enums.Continent;
import com.tenbeggar.pob.repository.SummonerMatchRepository;
import com.tenbeggar.pob.riot.domain.Match;
import com.tenbeggar.pob.service.DragonService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.client.RestTemplate;

import java.time.ZonedDateTime;
import java.util.List;

@SpringBootTest
public class APITest {

    private static final Logger log = LoggerFactory.getLogger(APITest.class);

    @Resource
    private RestTemplate restTemplate;

    private static final String SUMMONER_BY_NAME = "https://{region}.api.riotgames.com/lol/summoner/v4/summoners/by-name/{summonerName}";
    private static final String MATCHID_BY_CONTINENT_PUUID = "https://{continent}.api.riotgames.com/lol/match/v5/matches/by-puuid/{puuid}/ids?startTime={startTime}&endTime={endTime}&start={start}&count={count}";
    private static final String MATCH_BY_CONTINENT_MATCHID = "https://{continent}.api.riotgames.com/lol/match/v5/matches/{matchId}";

    @Test
    void summonerByName() {
        restTemplate.getForObject(SUMMONER_BY_NAME, String.class, "na1", "Honma Meikoo");
    }

    @Test
    void matchIdByPuuid() {
        restTemplate.getForObject(MATCHID_BY_CONTINENT_PUUID, List.class, Continent.americas, "mDiupEcNhbxpo0Mbqn-MLzKVTzhJKEoR4-Z0rGPYFuO7eeSyyccGQwAoj4V1y1ywH-PgKgRJDIRCgw",
                "", ZonedDateTime.now().toEpochSecond(), 0, 100);
    }

    @Test
    void match() {
        Match match = restTemplate.getForObject(MATCH_BY_CONTINENT_MATCHID, Match.class, Continent.asia, "KR_6823337832");
    }

    @Resource
    private SummonerMatchRepository summonerMatchRepository;

    @Test
    void summonerMatchPage() {
        Pageable pageable = PageRequest.of(1, 20, Sort.by("matchId").descending());
        Page<SummonerMatchEntity> summonerMatchPage = summonerMatchRepository.findAllByPuuid("nmJJhPeUug01hc1lsleyTGgIK2L27qnzbKQHVA6klM5XJ5_hAK8ykvsUF2gn362qnY2fGdML8-j-rg", pageable);
    }

    @Resource
    private DragonService dragonService;

    @Test
    void dataDragon() {
        String path = dragonService.downloadDataDragon("13.24.1");
    }

    @Test
    void champions() {
        dragonService.syncChampion("13.24.1", "zh_CN");
    }
}
