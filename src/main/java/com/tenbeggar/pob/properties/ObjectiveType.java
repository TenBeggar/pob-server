package com.tenbeggar.pob.properties;

import com.tenbeggar.pob.entity.ObjectiveEntity;
import com.tenbeggar.pob.entity.TeamEntity;
import com.tenbeggar.pob.riot.domain.Objectives;

import java.util.List;

/**
 * 目标类型
 */
public enum ObjectiveType {

    /**
     * 英雄
     */
    champion,

    /**
     * 小龙
     */
    dragon,

    /**
     * 峡谷先锋
     */
    riftHerald,

    /**
     * 纳什男爵
     */
    baron,

    /**
     * 防御塔
     */
    tower,

    /**
     * 水晶
     */
    inhibitor,

    /**
     * TODO
     */
    horde,
    ;

    /**
     * Objectives -> List<ObjectiveEntity>
     */
    public static List<ObjectiveEntity> objectivesToEntities(Objectives objectives, TeamEntity teamEntity) {
        Integer teamId = teamEntity.getTeamId();
        String gameVersion = teamEntity.getGameVersion();
        Long gameCreation = teamEntity.getGameCreation();
        Integer queueId = teamEntity.getQueueId();
        return List.of(
                ObjectiveEntity.builder()
                        .objectiveName(ObjectiveType.champion).first(objectives.getChampion().getFirst()).kills(objectives.getChampion().getKills())
                        .teamId(teamId).gameVersion(gameVersion).gameCreation(gameCreation).queueId(queueId)
                        .build(),
                ObjectiveEntity.builder()
                        .objectiveName(ObjectiveType.dragon).first(objectives.getDragon().getFirst()).kills(objectives.getDragon().getKills())
                        .teamId(teamId).gameVersion(gameVersion).gameCreation(gameCreation).queueId(queueId)
                        .build(),
                ObjectiveEntity.builder()
                        .objectiveName(ObjectiveType.riftHerald).first(objectives.getRiftHerald().getFirst()).kills(objectives.getRiftHerald().getKills())
                        .teamId(teamId).gameVersion(gameVersion).gameCreation(gameCreation).queueId(queueId)
                        .build(),
                ObjectiveEntity.builder()
                        .objectiveName(ObjectiveType.baron).first(objectives.getBaron().getFirst()).kills(objectives.getBaron().getKills())
                        .teamId(teamId).gameVersion(gameVersion).gameCreation(gameCreation).queueId(queueId)
                        .build(),
                ObjectiveEntity.builder()
                        .objectiveName(ObjectiveType.tower).first(objectives.getTower().getFirst()).kills(objectives.getTower().getKills())
                        .teamId(teamId).gameVersion(gameVersion).gameCreation(gameCreation).queueId(queueId)
                        .build(),
                ObjectiveEntity.builder()
                        .objectiveName(ObjectiveType.inhibitor).first(objectives.getInhibitor().getFirst()).kills(objectives.getInhibitor().getKills())
                        .teamId(teamId).gameVersion(gameVersion).gameCreation(gameCreation).queueId(queueId)
                        .build(),
                ObjectiveEntity.builder()
                        .objectiveName(ObjectiveType.horde).first(objectives.getHorde().getFirst()).kills(objectives.getHorde().getKills())
                        .teamId(teamId).gameVersion(gameVersion).gameCreation(gameCreation).queueId(queueId)
                        .build()
        );
    }
}
