package com.tenbeggar.pob.riot.domain;

import com.tenbeggar.pob.entity.ItemEntity;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.StringJoiner;

/**
 * 装备
 */
@Data
public class Item {

    private String id;//装备id
    private String name;//装备名
    private ItemGold gold;//价格
    private String group;//item
    private String description;//装备详情
    private String plaintext;//装备简介
    private Boolean consumed;//是否是消耗品
    private Integer stacks;//堆叠数量
    private Integer depth;//装备升级深度
    private Boolean consumeOnFull;//一次性消耗品：控制守卫，钢铁合剂，巫术合剂，愤怒合剂，帽子饮品，威能饮品，活力饮品，急速饮品，随意开火，死亡之女，鼓舞士气，戒备眼石，萌动眼石，警觉眼石，普朗克 占位
    private List<String> from;//升级所需装备
    private List<String> into;//可升级装备
    private Integer specialRecipe;//特殊配方，装备id
    private Boolean inStore;//是否来自商城
    private Boolean hideFromAll;//无加成装备：永续意志夹心饼干，小兵去质器，破损的秒表，你也有份（派克的R），普朗克 占位
    private String requiredChampion;//英雄特有装备：FiddleSticks.稻草人的草间人 Kalista|Sylas.卡莉丝塔的黑色长矛 Gangplank.随意开火|死亡之女|鼓舞士气|普朗克 占位
    private String requiredAlly;//来自队友：Ornn.奥恩
    private List<String> tags;//装备分类
    private java.util.Map<String, Boolean> maps;//适用地图
    private Image image;//装备图标

    //TODO 尚未理解
    private Object effect;
    private Object rune;
    private String colloq;
    private Object stats;

    private static final String DELIMITER = ",";

    public ItemEntity toEntity(Integer id, String version, String language) {
        ItemEntity itemEntity = new ItemEntity();
        BeanUtils.copyProperties(this, itemEntity);
        itemEntity.setId(id);
        if (!CollectionUtils.isEmpty(this.getFrom())) {
            itemEntity.setNeed(String.join(DELIMITER, this.getFrom()));
        }
        if (!CollectionUtils.isEmpty(this.getInto())) {
            itemEntity.setChange(String.join(DELIMITER, this.getInto()));
        }
        if (!CollectionUtils.isEmpty(this.getTags())) {
            itemEntity.setTags(String.join(DELIMITER, this.getTags()));
        }
        if (!CollectionUtils.isEmpty(this.getMaps())) {
            StringJoiner stringJoiner = new StringJoiner(DELIMITER);
            this.getMaps().forEach((v, k) -> {
                if (k) {
                    stringJoiner.add(v);
                }
            });
            itemEntity.setMaps(stringJoiner.toString());
        }
        itemEntity.setImage(this.getImage().getFull());
        ItemGold gold = this.getGold();
        itemEntity.setBase(gold.getBase());
        itemEntity.setPurchasable(gold.getPurchasable());
        itemEntity.setTotal(gold.getTotal());
        itemEntity.setSell(gold.getSell());
        itemEntity.setVersion(version);
        itemEntity.setLanguage(language);
        return itemEntity;
    }
}
