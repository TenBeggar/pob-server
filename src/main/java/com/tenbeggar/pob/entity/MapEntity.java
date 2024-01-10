package com.tenbeggar.pob.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 地图
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "map")
public class MapEntity extends BaseEntity {

    /**
     * 地图id
     */
    @Column(unique = true)
    private Integer mapId;

    /**
     * 地图名
     */
    private String mapName;

    /**
     * 说明
     */
    private String notes;
}
