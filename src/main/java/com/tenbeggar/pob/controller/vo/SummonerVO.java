package com.tenbeggar.pob.controller.vo;

import com.tenbeggar.pob.properties.Region;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "召唤师信息")
@Data
public class SummonerVO {

    @Schema(description = "召唤师pobId")
    private String pobId;
    @Schema(description = "召唤师名字")
    private String name;
    @Schema(description = "召唤师图标id，对应dragontail-{version}/{version}/img/profileicon目录下的图片")
    private Integer profileIconId;
    @Schema(description = "召唤师等级")
    private Long summonerLevel;
    @Schema(description = "召唤师所在大区： br1.巴西 eun1.北欧和东欧 euw1.西欧 jp1.日本 kr.韩国 la1.北拉丁美洲 la2.南拉丁美洲 na1.北美 oc1.澳大利亚 ph2.菲律宾 ru.俄罗斯 sg2.新加坡 th2.泰国 tr1.土耳其 tw2.台湾 vn2.越南")
    private Region region;
    @Schema(description = "修改日期（毫秒）")
    private Long revisionDate;
}
