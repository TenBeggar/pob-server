package com.tenbeggar.pob.enums;

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
        String matchId = teamEntity.getMatchId();
        Integer teamId = teamEntity.getTeamId();
        String gameVersion = teamEntity.getGameVersion();
        Long gameCreation = teamEntity.getGameCreation();
        Integer queueId = teamEntity.getQueueId();
        return List.of(
                ObjectiveEntity.builder()
                        .objectiveName(ObjectiveType.champion.name()).first(objectives.getChampion().getFirst()).kills(objectives.getChampion().getKills())
                        .matchId(matchId).teamId(teamId).gameVersion(gameVersion).gameCreation(gameCreation).queueId(queueId)
                        .build(),
                ObjectiveEntity.builder()
                        .objectiveName(ObjectiveType.dragon.name()).first(objectives.getDragon().getFirst()).kills(objectives.getDragon().getKills())
                        .matchId(matchId).teamId(teamId).gameVersion(gameVersion).gameCreation(gameCreation).queueId(queueId)
                        .build(),
                ObjectiveEntity.builder()
                        .objectiveName(ObjectiveType.riftHerald.name()).first(objectives.getRiftHerald().getFirst()).kills(objectives.getRiftHerald().getKills())
                        .matchId(matchId).teamId(teamId).gameVersion(gameVersion).gameCreation(gameCreation).queueId(queueId)
                        .build(),
                ObjectiveEntity.builder()
                        .objectiveName(ObjectiveType.baron.name()).first(objectives.getBaron().getFirst()).kills(objectives.getBaron().getKills())
                        .matchId(matchId).teamId(teamId).gameVersion(gameVersion).gameCreation(gameCreation).queueId(queueId)
                        .build(),
                ObjectiveEntity.builder()
                        .objectiveName(ObjectiveType.tower.name()).first(objectives.getTower().getFirst()).kills(objectives.getTower().getKills())
                        .matchId(matchId).teamId(teamId).gameVersion(gameVersion).gameCreation(gameCreation).queueId(queueId)
                        .build(),
                ObjectiveEntity.builder()
                        .objectiveName(ObjectiveType.inhibitor.name()).first(objectives.getInhibitor().getFirst()).kills(objectives.getInhibitor().getKills())
                        .matchId(matchId).teamId(teamId).gameVersion(gameVersion).gameCreation(gameCreation).queueId(queueId)
                        .build(),
                ObjectiveEntity.builder()
                        .objectiveName(ObjectiveType.horde.name()).first(objectives.getHorde().getFirst()).kills(objectives.getHorde().getKills())
                        .matchId(matchId).teamId(teamId).gameVersion(gameVersion).gameCreation(gameCreation).queueId(queueId)
                        .build()
        );
    }
}
