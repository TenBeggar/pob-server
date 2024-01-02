package com.tenbeggar.pob.riot.domain;

import lombok.Data;

/**
 * 禁用英雄
 */
@Data
public class Ban {

    /**
     * 英雄id
     */
    private Integer championId;

    /**
     * 禁选回合
     */
    private Integer pickTurn;
}
