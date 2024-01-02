package com.tenbeggar.pob.riot.domain;

import lombok.Data;

import java.util.List;

/**
 * 对局元数据
 */
@Data
public class MatchMetadata {

    /**
     * 数据版本
     */
    private String dataVersion;

    /**
     * 对局id
     */
    private String matchId;

    /**
     * 召唤师puuid
     */
    private List<String> participants;
}
