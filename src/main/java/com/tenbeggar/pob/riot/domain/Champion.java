package com.tenbeggar.pob.riot.domain;

import com.tenbeggar.pob.entity.ChampionEntity;
import com.tenbeggar.pob.utils.JsonUtils;
import lombok.Data;

import java.util.List;

@Data
public class Champion {

    private String id;//英文名
    private String key;//id
    private String name;//头衔，如：暗裔剑魔
    private String title;//名字，如：亚托克斯
    private Image image;//英雄图标
    private List<ChampionSkin> skins;//皮肤
    private String lore;//英雄背景
    private String blurb;//英雄背景
    private List<String> allytips;//英雄小技巧
    private List<String> enemytips;//对策小技巧
    private List<String> tags;//英雄定位 todo ：Fighter.战士 Mage.法师 Tank.坦克 Assassin.刺客
    private String partype;//剑意 护盾 勇气 猩红冲刺 能量 法力 热量 怒气 残暴 鲜血魔井 豪意 无
    private ChampionInfo info;//英雄评分
    private ChampionStats stats;//基础属性
    private List<ChampionSpell> spells;//技能属性
    private ChampionPassive passive;//被动技能
    private List<String> recommended;//建议

    private static final String DELIMITER = "\n";

    public ChampionEntity toEntity(String version, String language) {
        return ChampionEntity.builder()
                .id(Integer.valueOf(this.getKey())).enId(this.getId())
                .name(this.getName()).title(this.getTitle()).image(this.getImage().getFull())
                .lore(this.getLore()).blurb(this.getBlurb())
                .partype(this.getPartype())
                .score(JsonUtils.toJson(this.getInfo()))
                .allytips(String.join(DELIMITER, this.getAllytips())).enemytips(String.join(DELIMITER, this.getEnemytips())).recommended(String.join(DELIMITER, this.getRecommended()))
                .version(version).language(language)
                .build();
    }
}
