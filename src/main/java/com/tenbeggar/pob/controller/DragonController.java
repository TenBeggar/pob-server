package com.tenbeggar.pob.controller;

import com.tenbeggar.pob.controller.vo.GameModeVO;
import com.tenbeggar.pob.controller.vo.GameTypeVO;
import com.tenbeggar.pob.controller.vo.MapVO;
import com.tenbeggar.pob.controller.vo.QueueVO;
import com.tenbeggar.pob.riot.RiotProperties;
import com.tenbeggar.pob.service.DragonService;
import com.tenbeggar.pob.utils.RestVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @Operation(summary = "游戏模式")
    @GetMapping("/gameMode")
    public RestVO<List<GameModeVO>> gameMode() {
        List<GameModeVO> gameModeVOS = dragonService.allGameMode();
        return RestVO.OK(gameModeVOS);
    }

    @Operation(summary = "游戏类型")
    @GetMapping("/gameType")
    public RestVO<List<GameTypeVO>> gameType() {
        List<GameTypeVO> gameTypeVOS = dragonService.allGameType();
        return RestVO.OK(gameTypeVOS);
    }

    @Operation(summary = "地图")
    @GetMapping("/map")
    public RestVO<List<MapVO>> map() {
        List<MapVO> mapVOS = dragonService.allMap();
        return RestVO.OK(mapVOS);
    }

    @Operation(summary = "对局类型")
    @GetMapping("/queue")
    public RestVO<List<QueueVO>> queue() {
        List<QueueVO> queueVOS = dragonService.allQueue();
        return RestVO.OK(queueVOS);
    }

    @Resource
    private RiotProperties riotProperties;

    @Operation(summary = "设置token（后台暂启）")
    @PutMapping("/token/{auth}")
    public RestVO<Void> setToken(@PathVariable("auth") String token) {
        riotProperties.setToken(token);
        return RestVO.OK();
    }

    @Operation(summary = "初始化DOC（后台暂启）")
    @GetMapping("/doc")
    public RestVO<Void> doc() {
        dragonService.syncDoc();
        return RestVO.OK();
    }
}
