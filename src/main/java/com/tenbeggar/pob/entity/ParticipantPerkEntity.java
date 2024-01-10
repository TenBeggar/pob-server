package com.tenbeggar.pob.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

/**
 * 符文选择
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "participant_perk")
public class ParticipantPerkEntity extends BaseEntity {

    /**
     * 符文类型：primaryStyle.主系 subStyle.副系 statDefense statFlex statOffense
     */
    private String description;

    /**
     * 符文id
     */
    private Integer perkId;

    /**
     * 冗余字段，对局id
     */
    public String matchId;

    /**
     * 冗余字段，参与者id
     */
    private Integer participantId;

    /**
     * 冗余字段，英雄id
     */
    private Integer championId;

    /**
     * 冗余字段，是否胜利
     */
    private Boolean win;

    /**
     * 冗余字段，游戏版本
     */
    public String gameVersion;

    /**
     * 冗余字段，游戏创建时间
     */
    public Long gameCreation;

    /**
     * 冗余字段，对局类型id
     */
    public Integer queueId;
}
