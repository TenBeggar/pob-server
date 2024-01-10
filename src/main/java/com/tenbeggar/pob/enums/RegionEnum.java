package com.tenbeggar.pob.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 区域
 */
@Getter
@AllArgsConstructor
public enum RegionEnum {

    br1("Brazil", "巴西"),
    eun1("Europe Nordic & East", "北欧和东欧"),
    euw1("Europe West", "西欧"),
    jp1("Japan", "日本"),
    kr("Korea", "韩国"),
    la1("LAN", "北拉丁美洲"),
    la2("LAS", "南拉丁美洲"),
    na1("North America", "北美"),
    oc1("Oceania", "澳大利亚"),
    ph2("Philippines", "菲律宾"),
    ru("Russia", "俄罗斯"),
    sg2("Singapore", "新加坡"),
    th2("Thailand", "泰国"),
    tr1("Turkiye", "土耳其"),
    tw2("Taiwan", "台湾"),
    vn2("Vietnam", "越南"),
    ;

    private final String name;
    private final String description;

    public static ContinentEnum toContinent(String region) {
        return switch (region) {
            case "na1", "br1", "la1", "la2" -> ContinentEnum.americas;
            case "kr", "jp1" -> ContinentEnum.asia;
            case "oc1", "ph2", "sg2", "th2", "tw2", "vn2" -> ContinentEnum.sea;
            case "eun1", "euw1", "tr1", "ru" -> ContinentEnum.europe;
            default -> null;
        };
    }
}
