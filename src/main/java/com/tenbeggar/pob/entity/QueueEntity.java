package com.tenbeggar.pob.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 对局类型
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "queue")
public class QueueEntity extends BaseEntity {

    /**
     * 对局类型id
     */
    @Column(unique = true)
    private Integer queueId;

    /**
     * 地图
     */
    private String map;

    /**
     * 描述
     */
    private String description;

    /**
     * 说明
     */
    private String notes;
}
