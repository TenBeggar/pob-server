package com.tenbeggar.pob.controller.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Schema(description = "队伍信息")
@Data
public class TeamVO {

    @Schema(description = "队伍id")
    private Integer teamId;
    @Schema(description = "是否获胜")
    private Boolean win;
    @Schema(description = "禁用英雄")
    private List<BanVO> bans;
    @Schema(description = "击杀目标")
    private List<ObjectiveVO> objectives;
}
