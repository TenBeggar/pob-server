package com.tenbeggar.pob.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 英雄定位
 */
@Getter
@AllArgsConstructor
public enum ChampionTagEnum {

    Fighter("战士"),
    Tank("坦克"),
    Mage("法师"),
    Assassin("刺客"),
    Marksman("射手"),
    Support("辅助"),
    ;

    private final String name;
}
