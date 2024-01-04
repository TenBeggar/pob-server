package com.tenbeggar.pob.enums;

/**
 * 区域
 */
public enum Region {

    /**
     * Brazil 巴西
     */
    br1,

    /**
     * Europe Nordic & East 北欧和东欧
     */
    eun1,

    /**
     * Europe West 西欧
     */
    euw1,

    /**
     * Japan 日本
     */
    jp1,

    /**
     * Korea 韩国
     */
    kr,

    /**
     * LAN 北拉丁美洲
     */
    la1,

    /**
     * LAS 南拉丁美洲
     */
    la2,

    /**
     * North America 北美
     */
    na1,

    /**
     * Oceania 澳大利亚
     */
    oc1,

    /**
     * Philippines 菲律宾
     */
    ph2,

    /**
     * Russia 俄罗斯
     */
    ru,

    /**
     * Singapore 新加坡
     */
    sg2,

    /**
     * Thailand 泰国
     */
    th2,

    /**
     * Turkiye 土耳其
     */
    tr1,

    /**
     * Taiwan 台湾
     */
    tw2,

    /**
     * Vietnam 越南
     */
    vn2,
    ;

    public static Continent toContinent(String region) {
        return switch (region) {
            case "na1", "br1", "la1", "la2" -> Continent.americas;
            case "kr", "jp1" -> Continent.asia;
            case "oc1", "ph2", "sg2", "th2", "tw2", "vn2" -> Continent.sea;
            case "eun1", "euw1", "tr1", "ru" -> Continent.europe;
            default -> null;
        };
    }
}
