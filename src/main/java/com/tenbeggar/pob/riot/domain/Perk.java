package com.tenbeggar.pob.riot.domain;

import com.tenbeggar.pob.entity.PerkEntity;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 符文
 */
@Data
public class Perk {

    private Integer id;//英文id
    private String key;//id
    private String icon;//图标
    private String name;//符文名称
    private List<PerkSlot> slots;//下级符文

    public List<PerkEntity> toEntity(String version, String language) {
        PerkEntity perkEntity = new PerkEntity();
        BeanUtils.copyProperties(this, perkEntity);
        perkEntity.setEnId(this.getKey());
        perkEntity.setVersion(version);
        perkEntity.setLanguage(language);
        List<PerkEntity> perkEntities = this.getSlots().stream().map(PerkSlot::getRunes).map(e ->
                e.stream().map(a -> a.toEntity(version, language, this)).collect(Collectors.toList())
        ).flatMap(List::stream).collect(Collectors.toList());
        perkEntities.add(perkEntity);
        return perkEntities;
    }
}
