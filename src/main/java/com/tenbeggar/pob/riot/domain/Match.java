package com.tenbeggar.pob.riot.domain;

import lombok.Data;

@Data
public class Match {

    /**
     * 对局元数据
     */
    private MatchMetadata metadata;

    /**
     * 对局详情
     */
    private MatchInfo info;
}
