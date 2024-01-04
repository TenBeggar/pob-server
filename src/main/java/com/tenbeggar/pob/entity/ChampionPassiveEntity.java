package com.tenbeggar.pob.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 英雄被动技能
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "champion_passive")
public class ChampionPassiveEntity extends BaseEntity {

    /**
     * 技能名
     */
    private String name;

    /**
     * 技能介绍
     */
    private String description;

    /**
     * 技能图标
     */
    private String image;

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
