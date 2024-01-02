package com.tenbeggar.pob.controller.vo;

import com.tenbeggar.pob.properties.ObjectiveType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "击杀目标")
@Data
public class ObjectiveVO {

    @Schema(description = "目标类型：champion.英雄 dragon.小龙 riftHerald.峡谷先锋 baron.纳什男爵 tower.防御塔 inhibitor.水晶 horde.")
    private ObjectiveType objectiveName;
    @Schema(description = "是否首杀")
    private Boolean first;
    @Schema(description = "击杀次数")
    private Integer kills;
}
