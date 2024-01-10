package com.tenbeggar.pob.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 队伍信息
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "team")
public class TeamEntity extends BaseEntity {

    /**
     * 队伍id
     */
    private Integer teamId;

    /**
     * 是否获胜
     */
    private Boolean win;

    /**
     * 冗余字段，对局id
     */
    public String matchId;

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
}
