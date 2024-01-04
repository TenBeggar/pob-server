package com.tenbeggar.pob.service;

import com.tenbeggar.pob.entity.MatchTaskBillboardEntity;
import com.tenbeggar.pob.entity.MatchTaskEntity;
import com.tenbeggar.pob.enums.TaskStatus;
import com.tenbeggar.pob.manager.MatchTaskEvent;
import com.tenbeggar.pob.repository.MatchTaskBillboardRepository;
import com.tenbeggar.pob.repository.MatchTaskRepository;
import jakarta.annotation.Resource;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.Objects;

@Repository
public class MatchTaskBillboardService {

    /**
     * 起始页码
     */
    private static final int START_PAGE = 0;

    /**
     * 每页最多长度
     */
    private static final int DEFAULT_COUNT = 20;

    @Resource
    private ApplicationEventPublisher applicationEventPublisher;

    @Resource
    private MatchTaskBillboardRepository matchTaskBillboardRepository;
    @Resource
    private MatchTaskRepository matchTaskRepository;

    /**
     * 发布任务-同步召唤师对局记录到当下
     */
    @Transactional
    public void postMatchTask(String continent, String puuid) {
        MatchTaskBillboardEntity matchTaskBillboardEntity = matchTaskBillboardRepository.findByContinentAndPuuid(continent, puuid);
        if (Objects.isNull(matchTaskBillboardEntity)) {
            matchTaskBillboardEntity = MatchTaskBillboardEntity.builder()
                    .continent(continent).puuid(puuid)
                    .startTime(null).endTime(ZonedDateTime.now().toEpochSecond()).build();
        } else {
            matchTaskBillboardEntity.setStartTime(matchTaskBillboardEntity.getEndTime());
            matchTaskBillboardEntity.setEndTime(ZonedDateTime.now().toEpochSecond());
        }
        matchTaskBillboardRepository.save(matchTaskBillboardEntity);
        MatchTaskEntity matchTaskEntity = this.editMatchTask(matchTaskBillboardEntity);
        matchTaskEntity = matchTaskRepository.save(matchTaskEntity);
        applicationEventPublisher.publishEvent(new MatchTaskEvent(this, matchTaskEntity));
    }

    /**
     * 编辑任务内容
     */
    private MatchTaskEntity editMatchTask(MatchTaskBillboardEntity matchTaskBillboardEntity) {
        return MatchTaskEntity.builder()
                .continent(matchTaskBillboardEntity.getContinent()).puuid(matchTaskBillboardEntity.getPuuid())
                .startTime(matchTaskBillboardEntity.getStartTime()).endTime(matchTaskBillboardEntity.getEndTime())
                .start(START_PAGE).count(DEFAULT_COUNT)
                .status(TaskStatus.NONE).retryCount(0).build();
    }

    /**
     * 发布下一阶段任务
     */
    public void nextStageTask(MatchTaskEntity matchTaskEntity) {
        MatchTaskEntity nextMatchTaskEntity = MatchTaskEntity.builder()
                .continent(matchTaskEntity.getContinent()).puuid(matchTaskEntity.getPuuid())
                .startTime(matchTaskEntity.getStartTime()).endTime(matchTaskEntity.getEndTime())
                .start(matchTaskEntity.getStart() + matchTaskEntity.getCount()).count(matchTaskEntity.getCount())
                .status(TaskStatus.NONE).retryCount(0).build();
        matchTaskRepository.save(nextMatchTaskEntity);
    }

    /**
     * 找到一个未完成的任务
     */
    public MatchTaskEntity firstMatchTaskByStatus(TaskStatus taskStatus) {
        return matchTaskRepository.findFirstByStatus(taskStatus);
    }

    /**
     * 记录任务完成情况
     */
    public void saveMatchTask(MatchTaskEntity matchTaskEntity) {
        matchTaskRepository.save(matchTaskEntity);
    }
}
