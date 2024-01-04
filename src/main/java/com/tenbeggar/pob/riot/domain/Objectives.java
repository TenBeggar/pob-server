package com.tenbeggar.pob.riot.domain;

import lombok.Data;

/**
 * 击杀目标
 */
@Data
public class Objectives {

    /**
     * 击杀英雄情况
     */
    private Objective champion;

    /**
     * 小龙
     */
    private Objective dragon;

    /**
     * 峡谷先锋
     */
    private Objective riftHerald;

    /**
     * 纳什男爵
     */
    private Objective baron;

    /**
     * 防御塔
     */
    private Objective tower;

    /**
     * 水晶
     */
    private Objective inhibitor;

    private Objective horde;//TODO
}
