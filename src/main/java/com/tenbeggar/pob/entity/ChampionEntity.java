package com.tenbeggar.pob.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.*;

/**
 * 英雄
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "champion", uniqueConstraints = @UniqueConstraint(columnNames = {"id", "version", "language"}))
public class ChampionEntity extends BaseEntity {

    /**
     * 英雄id
     */
    private Integer id;

    /**
     * 英文id
     */
    private String enId;

    /**
     * 头衔，如：暗裔剑魔
     */
    private String name;

    /**
     * 名字，如：亚托克斯
     */
    private String title;

    /**
     * 英雄图标
     */
    private String image;

    /**
     * 英雄背景
     */
    private String lore;

    /**
     * 英雄背景
     */
    private String blurb;

    /**
     * 英雄小技巧
     */
    private String allytips;

    /**
     * 对策小技巧
     */
    private String enemytips;

//    private List<String> tags;//英雄定位 todo ：Fighter.战士 Mage.法师 Tank.坦克 Assassin.刺客

    /**
     * 剑意 护盾 勇气 猩红冲刺 能量 法力 热量 怒气 残暴 鲜血魔井 豪意 无
     */
    private String partype;

    /**
     * 英雄评分
     */
    private String score;

    /**
     * 建议
     */
    private String recommended;


    /**
     * 冗余字段，版本
     */
    private String version;

    /**
     * 冗余字段，语言
     */
    private String language;
}
