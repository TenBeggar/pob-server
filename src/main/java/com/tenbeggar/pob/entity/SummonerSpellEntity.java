package com.tenbeggar.pob.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 召唤师技能
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "summoner_spell", uniqueConstraints = @UniqueConstraint(columnNames = {"id", "version", "language"}))
public class SummonerSpellEntity extends BaseEntity {

    /**
     * 英雄id
     */
    private Integer id;

    /**
     * 英文id
     */
    private String enId;

    /**
     * 名字
     */
    private String name;

    /**
     * 技能描述
     */
    private String description;

    /**
     * 冷却时间
     */
    private String cooldownBurn;

    /**
     * 技能消耗
     */
    private String costBurn;

    /**
     * 消耗类型，都为无消耗
     */
    private String costType;

    /**
     * 技能范围
     */
    private String rangeBurn;

    /**
     * 最低要求的召唤师等级
     */
    private Integer summonerLevel;

    /**
     * 支持的游戏模式，GameMode枚举的子集
     */
    private String modes;

    /**
     * 可升级次数，都为1
     */
    private Integer maxrank;

    /**
     * 填充次数，除了惩戒为2，其余都为-1
     */
    private String maxammo;

    /**
     * 技能图标
     */
    private String image;

    /**
     * 冗余字段，版本
     */
    private String version;

    /**
     * 冗余字段，语言
     */
    private String language;
}
