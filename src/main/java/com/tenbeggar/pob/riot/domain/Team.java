package com.tenbeggar.pob.riot.domain;

import com.tenbeggar.pob.entity.MatchEntity;
import com.tenbeggar.pob.entity.TeamEntity;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * 队伍信息
 */
@Data
public class Team {

    /**
     * 队伍id
     */
    private Integer teamId;

    /**
     * 禁用英雄
     */
    private List<Ban> bans;

    /**
     * 击杀目标情况
     */
    private Objectives objectives;

    /**
     * 是否获胜
     */
    private Boolean win;

    public TeamEntity toEntity(MatchEntity matchEntity) {
        TeamEntity teamEntity = new TeamEntity();
        BeanUtils.copyProperties(this, teamEntity);
        teamEntity.setMatchId(matchEntity.getMatchId());
        teamEntity.setGameVersion(matchEntity.getGameVersion());
        teamEntity.setGameCreation(matchEntity.getGameCreation());
        teamEntity.setQueueId(matchEntity.getQueueId());
        return teamEntity;
    }
}
