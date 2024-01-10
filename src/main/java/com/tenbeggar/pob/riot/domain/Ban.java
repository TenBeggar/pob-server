package com.tenbeggar.pob.riot.domain;

import com.tenbeggar.pob.entity.BanEntity;
import com.tenbeggar.pob.entity.TeamEntity;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * 禁用英雄
 */
@Data
public class Ban {

    /**
     * 英雄id
     */
    private Integer championId;

    /**
     * 禁选回合
     */
    private Integer pickTurn;

    public BanEntity toEntity(TeamEntity teamEntity) {
        BanEntity banEntity = new BanEntity();
        BeanUtils.copyProperties(this, banEntity);
        banEntity.setMatchId(teamEntity.getMatchId());
        banEntity.setTeamId(teamEntity.getTeamId());
        banEntity.setGameVersion(teamEntity.getGameVersion());
        banEntity.setGameCreation(teamEntity.getGameCreation());
        banEntity.setQueueId(teamEntity.getQueueId());
        return banEntity;
    }
}
