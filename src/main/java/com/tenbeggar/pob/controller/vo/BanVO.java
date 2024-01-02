package com.tenbeggar.pob.controller.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "禁用英雄")
@Data
public class BanVO {

    @Schema(description = "英雄id")
    private Integer championId;
    @Schema(description = "禁选回合")
    private Integer pickTurn;
}
