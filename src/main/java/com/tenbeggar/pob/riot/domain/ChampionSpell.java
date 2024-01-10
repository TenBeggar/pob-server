package com.tenbeggar.pob.riot.domain;

import com.tenbeggar.pob.entity.ChampionSpellEntity;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * 英雄主动技能
 */
@Data
public class ChampionSpell {

    private String id;//技能id
    private String name;//技能名
    private String description;//技能介绍

    private String cooldownBurn;//冷却时间
    private String costBurn;//技能消耗
    private String rangeBurn;//技能范围

    private Integer maxrank;//可升级次数
    private String maxammo;//充能次数

    private Image image;//技能图标

    //TODO 尚未理解
    private String tooltip;//技能详情
    private String costType;//消耗类型
    private Object leveltip;
    private Object datavalues;
    private List<String> effectBurn;
    private List<String> vars;
    private String resource;

    public ChampionSpellEntity toEntity(Integer championId, String version, String language) {
        ChampionSpellEntity championSpellEntity = new ChampionSpellEntity();
        BeanUtils.copyProperties(this, championSpellEntity);
        championSpellEntity.setImage(this.getImage().getFull());
        championSpellEntity.setChampionId(championId);
        championSpellEntity.setVersion(version);
        championSpellEntity.setLanguage(language);
        return championSpellEntity;
    }
}
