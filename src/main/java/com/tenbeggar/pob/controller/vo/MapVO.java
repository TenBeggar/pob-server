package com.tenbeggar.pob.controller.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "地图")
@Data
public class MapVO {

    @Schema(description = "地图id")
    private Integer mapId;
    @Schema(description = "地图名")
    private String mapName;
    @Schema(description = "说明")
    private String notes;
}
