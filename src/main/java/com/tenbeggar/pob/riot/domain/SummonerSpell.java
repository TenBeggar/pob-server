package com.tenbeggar.pob.riot.domain;

import com.tenbeggar.pob.entity.SummonerSpellEntity;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * 召唤师技能
 */
@Data
public class SummonerSpell {

    private String id;//英文名
    private String key;//id
    private String name;//名字
    private String description;//技能描述

    private String cooldownBurn;//冷却时间
    private String costBurn;//技能消耗
    private String costType;//消耗类型，都为无消耗
    private String rangeBurn;//技能范围

    private Integer summonerLevel;//最低要求的召唤师等级
    private List<String> modes;//支持的游戏模式，GameMode枚举的子集

    private Integer maxrank;//可升级次数，都为1
    private String maxammo;//填充次数，除了惩戒为2，其余都为-1

    private Image image;//技能图标

    //TODO 尚未理解
    private String tooltip;//技能详情
    private Object datavalues;
    private List<String> effectBurn;
    private List<String> vars;
    private String resource;

    private static final String DELIMITER = ",";

    public SummonerSpellEntity toEntity(String version, String language) {
        SummonerSpellEntity summonerSpellEntity = new SummonerSpellEntity();
        BeanUtils.copyProperties(this, summonerSpellEntity);
        summonerSpellEntity.setImage(this.getImage().getFull());
        summonerSpellEntity.setId(Integer.valueOf(this.getKey()));
        summonerSpellEntity.setEnId(this.getId());
        summonerSpellEntity.setModes(String.join(DELIMITER, this.getModes()));
        summonerSpellEntity.setVersion(version);
        summonerSpellEntity.setLanguage(language);
        return summonerSpellEntity;
    }
}
