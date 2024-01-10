package com.tenbeggar.pob.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "召唤师对局统计")
@Data
public class MatchStatDTO {

    @Schema(description = "召唤师pobId")
    private String summonerPobId;
    @Schema(description = "前n个")
    private Integer top;
}
