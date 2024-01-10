package com.tenbeggar.pob.controller.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "游戏类型")
@Data
public class GameTypeVO {

    @Schema(description = "游戏类型")
    private String gametype;
    @Schema(description = "描述")
    private String description;
}
