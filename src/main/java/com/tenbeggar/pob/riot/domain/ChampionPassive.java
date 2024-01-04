package com.tenbeggar.pob.riot.domain;

import com.tenbeggar.pob.entity.ChampionPassiveEntity;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class ChampionPassive {

    private String name;//技能名
    private String description;//技能介绍
    private Image image;//技能图标

    public ChampionPassiveEntity toEntity(Integer championId, String version, String language) {
        ChampionPassiveEntity championPassiveEntity = new ChampionPassiveEntity();
        BeanUtils.copyProperties(this, championPassiveEntity);
        championPassiveEntity.setImage(this.getImage().getFull());
        championPassiveEntity.setChampionId(championId);
        championPassiveEntity.setVersion(version);
        championPassiveEntity.setLanguage(language);
        return championPassiveEntity;
    }
}
