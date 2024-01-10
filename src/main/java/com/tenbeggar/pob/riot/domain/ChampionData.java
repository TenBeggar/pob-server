package com.tenbeggar.pob.riot.domain;

import lombok.Data;

import java.util.Map;

@Data
public class ChampionData {

    private String type;//类型
    private String format;
    private String version;//版本
    private Map<String, Champion> data;//英雄数据
}
