package com.tenbeggar.pob.entity;

import com.tenbeggar.pob.enums.TaskStatus;
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
@Table(name = "match_task")
public class MatchTaskEntity extends BaseEntity {

    /**
     * 州
     */
    private String continent;

    /**
     * 召唤师puuid
     */
    private String puuid;

    /**
     * 开始时间（秒），如果设置了该字段，则不包含2021年6月16日之前的比赛记录
     */
    private Long startTime;

    /**
     * 结束时间（秒）
     */
    private Long endTime;

    /**
     * 当前页，默认从0开始
     */
    private Integer start;

    /**
     * 每页的长度，有效值0-100
     */
    private Integer count;

    /**
     * 同步状态
     */
    @Enumerated(value = EnumType.STRING)
    private TaskStatus status;

    /**
     * 失败重试次数
     */
    private Integer retryCount;
}
