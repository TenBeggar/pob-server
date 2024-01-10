package com.tenbeggar.pob.riot.domain;

import lombok.Data;

/**
 * 地图
 */
@Data
public class Map {

    /**
     * 地图id
     */
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
