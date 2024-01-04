package com.tenbeggar.pob.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 禁用英雄
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "ban")
public class BanEntity extends BaseEntity {

    /**
     * 英雄id
     */
    private Integer championId;

    /**
     * 禁选回合
     */
    private Integer pickTurn;

    /**
     * 冗余字段，对局id
     */
    public String matchId;

    /**
     * 冗余字段，队伍id
     */
    private Integer teamId;

    /**
     * 冗余字段，游戏版本
     */
    public String gameVersion;

    /**
     * 冗余字段，游戏创建时间
     */
    public Long gameCreation;

    /**
     * 冗余字段，对局类型id
     */
    public Integer queueId;

    /**
     * 填充冗余字段
     */
    public void fill(TeamEntity teamEntity) {
        this.setMatchId(teamEntity.getMatchId());
        this.setTeamId(teamEntity.getTeamId());
        this.setGameVersion(teamEntity.getGameVersion());
        this.setGameCreation(teamEntity.getGameCreation());
        this.setQueueId(teamEntity.getQueueId());
    }
}
