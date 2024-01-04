package com.tenbeggar.pob.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 英雄皮肤
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "champion_skin")
public class ChampionSkinEntity extends BaseEntity {

    /**
     * 皮肤id
     */
    private String id;

    /**
     * 序号，发布顺序
     */
    private Integer num;

    /**
     * 名字
     */
    private String name;

    /**
     * 是否有颜色
     */
    private Boolean chromas;

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
