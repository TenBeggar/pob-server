package com.tenbeggar.pob.controller.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "英雄胜率")
@Data
public class ChampionRateVO {

    @Schema(description = "英雄id")
    private Integer championId;
    @Schema(description = "胜场")
    private Long totalWins;
    @Schema(description = "总场数")
    private Long totalGames;
    @Schema(description = "胜率")
    private Double winRate;
}
