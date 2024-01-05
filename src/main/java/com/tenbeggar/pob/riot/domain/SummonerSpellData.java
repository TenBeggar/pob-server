package com.tenbeggar.pob.riot.domain;

import lombok.Data;

import java.util.Map;

@Data
public class SummonerSpellData {

    private String type;
    private String version;
    private Map<String, SummonerSpell> data;
}
