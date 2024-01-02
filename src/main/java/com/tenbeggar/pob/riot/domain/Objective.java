package com.tenbeggar.pob.riot.domain;

import lombok.Data;

/**
 * 击杀总数
 */
@Data
public class Objective {

    /**
     * 首杀
     */
    private Boolean first;

    /**
     * 击杀次数
     */
    private Integer kills;
}
