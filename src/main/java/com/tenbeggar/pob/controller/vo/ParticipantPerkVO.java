package com.tenbeggar.pob.controller.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "符文选择")
@Data
public class ParticipantPerkVO {

    @Schema(description = "符文类型：primaryStyle.主系 subStyle.副系 statDefense statFlex statOffense")
    private String description;
    @Schema(description = "符文id")
    private List<Integer> perkId;
}
