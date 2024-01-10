package com.tenbeggar.pob.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 装备
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "item", uniqueConstraints = @UniqueConstraint(columnNames = {"id", "version", "language"}))
public class ItemEntity extends BaseEntity {

    /**
     * 装备id
     */
    private Integer id;

    /**
     * 装备名
     */
    private String name;

    /**
     * 装备详情
     */
    private String description;

    /**
     * 装备简介
     */
    private String plaintext;

    /**
     * 是否是消耗品
     */
    private Boolean consumed;

    /**
     * 堆叠数量
     */
    private Integer stacks;

    /**
     * 装备升级深度
     */
    private Integer depth;

    /**
     * 一次性消耗品：控制守卫，钢铁合剂，巫术合剂，愤怒合剂，帽子饮品，威能饮品，活力饮品，急速饮品，随意开火，死亡之女，鼓舞士气，戒备眼石，萌动眼石，警觉眼石，普朗克 占位
     */
    private Boolean consumeOnFull;

    /**
     * 升级所需装备
     */
    private String need;

    /**
     * 可升级装备
     */
    private String change;

    /**
     * 特殊配方，装备id
     */
    private Integer specialRecipe;

    /**
     * 是否来自商城
     */
    private Boolean inStore;

    /**
     * 无加成装备：永续意志夹心饼干，小兵去质器，破损的秒表，你也有份（派克的R），普朗克 占位
     */
    private Boolean hideFromAll;

    /**
     * 英雄特有装备：FiddleSticks.稻草人的草间人 Kalista|Sylas.卡莉丝塔的黑色长矛 Gangplank.随意开火|死亡之女|鼓舞士气|普朗克 占位
     */
    private String requiredChampion;

    /**
     * 来自队友：Ornn.奥恩
     */
    private String requiredAlly;

    /**
     * 装备分类
     */
    private String tags;

    /**
     * 适用地图
     */
    private String maps;

    /**
     * 装备图标
     */
    private String image;

    /**
     * 售价或合成费用
     */
    private Integer base;

    /**
     * 是否可购买
     */
    private Boolean purchasable;

    /**
     * 总价格
     */
    private Integer total;

    /**
     * 卖出价格
     */
    private Integer sell;

    /**
     * 冗余字段，版本
     */
    private String version;

    /**
     * 冗余字段，语言
     */
    private String language;
}
