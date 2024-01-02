package com.tenbeggar.pob.events;

import com.tenbeggar.pob.entity.MatchTaskEntity;
import com.tenbeggar.pob.entity.SummonerMatchEntity;
import com.tenbeggar.pob.properties.Continent;
import com.tenbeggar.pob.properties.TaskStatus;
import com.tenbeggar.pob.repository.SummonerMatchRepository;
import com.tenbeggar.pob.riot.MatchClient;
import com.tenbeggar.pob.service.MatchService;
import com.tenbeggar.pob.service.MatchTaskBillboardService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Component
public class MatchTaskManager {

    @Resource
    private ApplicationEventPublisher applicationEventPublisher;

    @Resource
    private SummonerMatchRepository summonerMatchRepository;

    @Resource
    private MatchTaskBillboardService matchTaskBillboardService;
    @Resource
    private MatchService matchService;

    @Resource
    private MatchClient matchClient;

    @Scheduled(fixedDelayString = "${clock.delay.match}")
    public void noneMatch() {
        MatchTaskEntity matchTaskEntity = matchTaskBillboardService.firstMatchTaskByStatus(TaskStatus.NONE);
        applicationEventPublisher.publishEvent(new MatchTaskEvent(this, matchTaskEntity));
    }

    @Scheduled(fixedDelayString = "${clock.delay.retry-match}")
    public void retryMatch() {
        MatchTaskEntity matchTaskEntity = matchTaskBillboardService.firstMatchTaskByStatus(TaskStatus.FAIL);
        applicationEventPublisher.publishEvent(new MatchTaskEvent(this, matchTaskEntity));
    }

    @EventListener(classes = MatchTaskEvent.class)
    @Transactional
    public void execMatch(MatchTaskEvent matchTaskEvent) {
        MatchTaskEntity matchTaskEntity = matchTaskEvent.getMatchTaskEntity();
        if (Objects.isNull(matchTaskEntity)) {
            return;
        }
        Continent continent = matchTaskEntity.getContinent();
        String puuid = matchTaskEntity.getPuuid();
        List<String> matchIds = null;
        try {
            matchIds = matchClient.findAllMatchIdByContinentAndPuuid(continent, puuid, matchTaskEntity.getStartTime(), matchTaskEntity.getEndTime(), matchTaskEntity.getStart(), matchTaskEntity.getCount());
            matchTaskEntity.setStatus(TaskStatus.SUCCESS);
        } catch (Exception e) {
            matchTaskEntity.setStatus(TaskStatus.FAIL);
            matchTaskEntity.setRetryCount(matchTaskEntity.getRetryCount() + 1);
            log.error("matchTask : {}\nerror : {}", matchTaskEntity, e.getMessage());
        }
        matchTaskBillboardService.saveMatchTask(matchTaskEntity);
        if (CollectionUtils.isEmpty(matchIds)) {
            return;
        }
        List<SummonerMatchEntity> summonerMatchEntities = matchIds.stream().map(e -> SummonerMatchEntity.builder().puuid(puuid).matchId(e).build()).collect(Collectors.toList());
        summonerMatchRepository.saveAll(summonerMatchEntities);
        matchService.saveAllByContinentAndMatchIds(continent, matchIds);
        if (matchTaskEntity.getCount() == matchIds.size()) {
            //TODO 如果用户一直下拉，由于定时任务可能还没执行下一阶段任务，会导致用户查询的结果缺失
            matchTaskBillboardService.nextStageTask(matchTaskEntity);
        }
    }
}
