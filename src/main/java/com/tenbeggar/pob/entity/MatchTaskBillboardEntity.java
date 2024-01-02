package com.tenbeggar.pob.entity;

import com.tenbeggar.pob.properties.Continent;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "match_task_billboard")
public class MatchTaskBillboardEntity extends BaseEntity {

    /**
     * 州
     */
    @Enumerated(value = EnumType.STRING)
    private Continent continent;

    /**
     * 召唤师puuid
     */
    private String puuid;

    /**
     * 上次同步时间（秒）
     */
    private Long startTime;

    /**
     * 当前时间（秒）
     */
    private Long endTime;
}
