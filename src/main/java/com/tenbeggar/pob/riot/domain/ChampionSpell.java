package com.tenbeggar.pob.riot.domain;

import com.tenbeggar.pob.entity.ChampionSpellEntity;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class ChampionSpell {

    private String id;//技能id
    private String name;//技能名
    private String description;//技能介绍
    private String tooltip;//技能详情

    private String cooldownBurn;//冷却时间
    private String costBurn;//法力消耗

    private Image image;//技能图标

    //TODO

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
