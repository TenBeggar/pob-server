package com.tenbeggar.pob.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 符文
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "perk", uniqueConstraints = @UniqueConstraint(columnNames = {"id", "version", "language"}))
public class PerkEntity extends BaseEntity {

    /**
     * 符文id
     */
    private Integer id;

    /**
     * 英文id
     */
    private String enId;

    /**
     * 符文名称
     */
    private String name;

    /**
     * 图标
     */
    private String icon;

    /**
     * 简单描述
     */
    private String shortDesc;

    /**
     * 整体描述
     */
    private String longDesc;

    /**
     * 父级id
     */
    private Integer parentId;

    /**
     * 冗余字段，版本
     */
    private String version;

    /**
     * 冗余字段，语言
     */
    private String language;
}
