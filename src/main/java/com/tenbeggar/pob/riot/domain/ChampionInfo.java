package com.tenbeggar.pob.riot.domain;

import lombok.Data;

/**
 * 英雄评分
 */
@Data
public class ChampionInfo {

    private Integer attack;//攻击
    private Integer defense;//防守
    private Integer magic;//魔法
    private Integer difficulty;//难度
}
