package com.tenbeggar.pob.controller.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "游戏模式")
@Data
public class GameModeVO {

    @Schema(description = "游戏模式")
    private String gameMode;
    @Schema(description = "描述")
    private String description;
}
