package com.tenbeggar.pob.enums;

import com.tenbeggar.pob.entity.ObjectiveEntity;
import com.tenbeggar.pob.entity.TeamEntity;
import com.tenbeggar.pob.riot.domain.Objectives;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 目标类型
 */
@Getter
@AllArgsConstructor
public enum ObjectiveTypeEnum {

    champion("英雄"),
    dragon("小龙"),
    riftHerald("峡谷先锋"),
    baron("纳什男爵"),
    tower("防御塔"),
    inhibitor("水晶"),
    horde("horde"),//TODO
    ;

    private final String name;

    /**
     * Objectives -> List<ObjectiveEntity>
     */
    public static List<ObjectiveEntity> objectivesToEntities(Objectives objectives, TeamEntity teamEntity) {
        String matchId = teamEntity.getMatchId();
        Integer teamId = teamEntity.getTeamId();
        String gameVersion = teamEntity.getGameVersion();
        Long gameCreation = teamEntity.getGameCreation();
        Integer queueId = teamEntity.getQueueId();
        List<ObjectiveEntity> objectiveEntities = new ArrayList<>();
        objectiveEntities.add(ObjectiveEntity.builder()
                .objectiveName(ObjectiveTypeEnum.champion.name()).first(objectives.getChampion().getFirst()).kills(objectives.getChampion().getKills())
                .matchId(matchId).teamId(teamId).gameVersion(gameVersion).gameCreation(gameCreation).queueId(queueId)
                .build());
        objectiveEntities.add(ObjectiveEntity.builder()
                .objectiveName(ObjectiveTypeEnum.dragon.name()).first(objectives.getDragon().getFirst()).kills(objectives.getDragon().getKills())
                .matchId(matchId).teamId(teamId).gameVersion(gameVersion).gameCreation(gameCreation).queueId(queueId)
                .build());
        objectiveEntities.add(ObjectiveEntity.builder()
                .objectiveName(ObjectiveTypeEnum.riftHerald.name()).first(objectives.getRiftHerald().getFirst()).kills(objectives.getRiftHerald().getKills())
                .matchId(matchId).teamId(teamId).gameVersion(gameVersion).gameCreation(gameCreation).queueId(queueId)
                .build());
        objectiveEntities.add(ObjectiveEntity.builder()
                .objectiveName(ObjectiveTypeEnum.baron.name()).first(objectives.getBaron().getFirst()).kills(objectives.getBaron().getKills())
                .matchId(matchId).teamId(teamId).gameVersion(gameVersion).gameCreation(gameCreation).queueId(queueId)
                .build());
        objectiveEntities.add(ObjectiveEntity.builder()
                .objectiveName(ObjectiveTypeEnum.tower.name()).first(objectives.getTower().getFirst()).kills(objectives.getTower().getKills())
                .matchId(matchId).teamId(teamId).gameVersion(gameVersion).gameCreation(gameCreation).queueId(queueId)
                .build());
        objectiveEntities.add(ObjectiveEntity.builder()
                .objectiveName(ObjectiveTypeEnum.inhibitor.name()).first(objectives.getInhibitor().getFirst()).kills(objectives.getInhibitor().getKills())
                .matchId(matchId).teamId(teamId).gameVersion(gameVersion).gameCreation(gameCreation).queueId(queueId)
                .build());
        if (Objects.nonNull(objectives.getHorde())) {
            objectiveEntities.add(ObjectiveEntity.builder()
                    .objectiveName(ObjectiveTypeEnum.horde.name()).first(objectives.getHorde().getFirst()).kills(objectives.getHorde().getKills())
                    .matchId(matchId).teamId(teamId).gameVersion(gameVersion).gameCreation(gameCreation).queueId(queueId)
                    .build());
        }
        return objectiveEntities;
    }
}
