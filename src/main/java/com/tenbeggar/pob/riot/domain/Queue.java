package com.tenbeggar.pob.riot.domain;

import lombok.Data;

/**
 * 对局类型
 */
@Data
public class Queue {

    /**
     * 对局类型id
     */
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
