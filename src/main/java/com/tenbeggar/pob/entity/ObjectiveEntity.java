package com.tenbeggar.pob.entity;

import com.tenbeggar.pob.properties.ObjectiveType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.*;

/**
 * 击杀目标
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "objective")
public class ObjectiveEntity extends BaseEntity {

    /**
     * 目标类型
     */
    @Enumerated(value = EnumType.STRING)
    private ObjectiveType objectiveName;

    /**
     * 是否首杀
     */
    private Boolean first;

    /**
     * 击杀次数
     */
    private Integer kills;

    /**
     * 冗余字段，队伍id
     */
    private Integer teamId;

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
