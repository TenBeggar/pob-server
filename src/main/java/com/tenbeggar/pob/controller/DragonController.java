package com.tenbeggar.pob.controller;

import com.tenbeggar.pob.riot.RiotProperties;
import com.tenbeggar.pob.service.DragonService;
import com.tenbeggar.pob.utils.RestVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@Tag(name = "资源")
@RestController
@RequestMapping("/dragon")
public class DragonController {

    @Resource
    private DragonService dragonService;

    @Operation(summary = "当前使用的LOL版本")
    @GetMapping("/version")
    public RestVO<String> version() {
        String version = dragonService.getCurrentVersion();
        return RestVO.OK(version);
    }

    @Resource
    private RiotProperties riotProperties;

    @Operation(summary = "设置token（后台暂启）")
    @PutMapping("/token/{auth}")
    public RestVO<Void> setToken(@PathVariable("auth") String token) {
        riotProperties.setToken(token);
        return RestVO.OK();
    }
}
