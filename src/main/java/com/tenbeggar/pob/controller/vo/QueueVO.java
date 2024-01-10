package com.tenbeggar.pob.controller.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "对局类型")
@Data
public class QueueVO {

    @Schema(description = "对局类型id")
    private Integer queueId;
    @Schema(description = "地图")
    private String map;
    @Schema(description = "描述")
    private String description;
    @Schema(description = "说明")
    private String notes;
}
