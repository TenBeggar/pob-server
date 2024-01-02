package com.tenbeggar.pob.entity;

import com.tenbeggar.pob.properties.Region;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "summoner")
public class SummonerEntity extends BaseEntity {

    /**
     * 加密后的召唤师id，最大长度63个字符
     */
    private String id;

    /**
     * 加密后的账户id
     */
    private String accountId;

    /**
     * 加密后的puuid，精确长度78个字符
     */
    private String puuid;

    /**
     * 召唤师名字
     */
    private String name;

    /**
     * 召唤师图标id，对应dragontail-{version}/{version}/img/profileicon目录下的图片
     */
    private Integer profileIconId;

    /**
     * 修改日期（毫秒）
     */
    private Long revisionDate;

    /**
     * 召唤师等级
     */
    private Long summonerLevel;

    /**
     * 召唤师所在区域
     */
    @Enumerated(value = EnumType.STRING)
    private Region region;
}
