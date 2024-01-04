package com.tenbeggar.pob.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "查询召唤师信息")
@Data
public class SummonerDTO {

    @Schema(description = "召唤师所在大区： br1.巴西 eun1.北欧和东欧 euw1.西欧 jp1.日本 kr.韩国 la1.北拉丁美洲 la2.南拉丁美洲 na1.北美 oc1.澳大利亚 ph2.菲律宾 ru.俄罗斯 sg2.新加坡 th2.泰国 tr1.土耳其 tw2.台湾 vn2.越南")
    private String region;
    @Schema(description = "召唤师名字")
    private String name;
}
