package com.tenbeggar.pob.riot.domain;

import lombok.Data;

import java.util.List;

/**
 * 队伍信息
 */
@Data
public class Team {

    /**
     * 队伍id
     */
    private Integer teamId;

    /**
     * 禁用英雄
     */
    private List<Ban> bans;

    /**
     * 击杀目标情况
     */
    private Objectives objectives;

    /**
     * 是否获胜
     */
    private Boolean win;
}
