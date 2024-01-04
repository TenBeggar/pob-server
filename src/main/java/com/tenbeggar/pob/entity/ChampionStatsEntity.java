package com.tenbeggar.pob.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 英雄基础属性
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "champion_stats")
public class ChampionStatsEntity extends BaseEntity {

    /**
     * 基础生命值
     */
    private Integer hp;

    /**
     * 每级获得生命值
     */
    private Float hpperlevel;

    /**
     * 基础魔法值
     */
    private Integer mp;

    /**
     * 每级获得魔法值
     */
    private Float mpperlevel;

    /**
     * 移动速度
     */
    private Integer movespeed;

    /**
     * 基础护甲
     */
    private Integer armor;

    /**
     * 每级获得护甲
     */
    private Float armorperlevel;

    /**
     * 基础魔法抗性
     */
    private Integer spellblock;

    /**
     * 每级获得魔法抗性
     */
    private Float spellblockperlevel;

    /**
     * 攻击距离
     */
    private Integer attackrange;

    /**
     * 每秒生命回复
     */
    private Integer hpregen;

    /**
     * 每级获得生命回复
     */
    private Float hpregenperlevel;

    /**
     * 每秒魔法回复
     */
    private Integer mpregen;

    /**
     * 每级获得魔法回复
     */
    private Float mpregenperlevel;

    private Integer crit;//TODO
    private Float critperlevel;

    /**
     * 基础攻击力
     */
    private Integer attackdamage;

    /**
     * 每级获得攻击力
     */
    private Float attackdamageperlevel;

    /**
     * 每级获得攻击速度
     */
    private Float attackspeedperlevel;

    /**
     * 攻击速度 +n%
     */
    private Float attackspeed;

    /**
     * 冗余字段，英雄id
     */
    private Integer championId;

    /**
     * 冗余字段，版本
     */
    private String version;

    /**
     * 冗余字段，语言
     */
    private String language;
}
