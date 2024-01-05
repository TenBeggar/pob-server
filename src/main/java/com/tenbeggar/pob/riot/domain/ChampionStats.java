package com.tenbeggar.pob.riot.domain;

import com.tenbeggar.pob.entity.ChampionStatsEntity;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class ChampionStats {

    private Integer hp;//基础生命值
    private Float hpperlevel;//每级获得生命值
    private Integer mp;//基础魔法值
    private Float mpperlevel;//每级获得魔法值
    private Integer movespeed;//移动速度
    private Integer armor;//基础护甲
    private Float armorperlevel;//每级获得护甲
    private Integer spellblock;//基础魔法抗性
    private Float spellblockperlevel;//每级获得魔法抗性
    private Integer attackrange;//攻击距离
    private Float hpregen;//每秒生命回复
    private Float hpregenperlevel;//每级获得生命回复
    private Float mpregen;//每秒魔法回复
    private Float mpregenperlevel;//每级获得魔法回复
    private Integer crit;//
    private Float critperlevel;
    private Integer attackdamage;//基础攻击力
    private Float attackdamageperlevel;//每级获得攻击力
    private Float attackspeedperlevel;//每级获得攻击速度
    private Float attackspeed;//攻击速度 +n%

    public ChampionStatsEntity toEntity(Integer championId, String version, String language) {
        ChampionStatsEntity championStatsEntity = new ChampionStatsEntity();
        BeanUtils.copyProperties(this, championStatsEntity);
        championStatsEntity.setChampionId(championId);
        championStatsEntity.setVersion(version);
        championStatsEntity.setLanguage(language);
        return championStatsEntity;
    }
}
