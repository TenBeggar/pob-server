package com.tenbeggar.pob.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "查询最近比赛记录")
@EqualsAndHashCode(callSuper = true)
@Data
public class MatchDTO extends PageDTO {

    @Schema(description = "召唤师pobId")
    private String summonerPobId;
}
