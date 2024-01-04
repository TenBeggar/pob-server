package com.tenbeggar.pob.riot.domain;

import lombok.Data;

import java.util.Map;

@Data
public class ChampionMeta {

    private String type;
    private String format;
    private String version;
    private Map<String, Champion> data;
}
