package com.tenbeggar.pob.riot.domain;

import com.tenbeggar.pob.entity.ChampionSkinEntity;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class ChampionSkin {

    private String id;//皮肤id
    private Integer num;//序号，发布顺序
    private String name;//名字
    private Boolean chromas;//是否有颜色

    public ChampionSkinEntity toEntity(Integer championId, String version, String language) {
        ChampionSkinEntity championSkinEntity = new ChampionSkinEntity();
        BeanUtils.copyProperties(this, championSkinEntity);
        championSkinEntity.setChampionId(championId);
        championSkinEntity.setVersion(version);
        championSkinEntity.setLanguage(language);
        return championSkinEntity;
    }
}
