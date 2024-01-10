package com.tenbeggar.pob.riot.domain;

import lombok.Data;

import java.util.Map;

@Data
public class SummonerSpellData {

    private String type;//类型
    private String version;//版本
    private Map<String, SummonerSpell> data;//召唤师技能数据
}
