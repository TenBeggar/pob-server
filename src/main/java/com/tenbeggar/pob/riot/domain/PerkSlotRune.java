package com.tenbeggar.pob.riot.domain;

import com.tenbeggar.pob.entity.PerkEntity;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class PerkSlotRune {

    private Integer id;//英文id
    private String key;//id
    private String icon;//图标
    private String name;//符文名称
    private String shortDesc;//简单描述
    private String longDesc;//整体描述

    public PerkEntity toEntity(String version, String language, Perk perk) {
        PerkEntity perkEntity = new PerkEntity();
        BeanUtils.copyProperties(this, perkEntity);
        perkEntity.setEnId(this.getKey());
        perkEntity.setVersion(version);
        perkEntity.setLanguage(language);
        perkEntity.setParentId(perk.getId());
        return perkEntity;
    }
}
