package com.tenbeggar.pob.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 英雄技能
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "champion_spell")
public class ChampionSpellEntity extends BaseEntity {

    /**
     * 技能id
     */
    private String id;

    /**
     * 技能名
     */
    private String name;

    /**
     * 技能介绍
     */
    private String description;

    /**
     * 技能详情
     */
    private String tooltip;

    /**
     * 冷却时间
     */
    private String cooldownBurn;

    /**
     * 法力消耗
     */
    private String costBurn;

    /**
     * 技能图标
     */
    private String image;

    //TODO

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
