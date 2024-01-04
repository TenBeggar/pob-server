package com.tenbeggar.pob.entity;

import jakarta.persistence.Entity;
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
    private String continent;

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
