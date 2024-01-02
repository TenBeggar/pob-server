package com.tenbeggar.pob.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PageDTO {

    @Schema(description = "页码")
    private int current = 1;
    @Schema(description = "行数")
    private int size = 20;
}
