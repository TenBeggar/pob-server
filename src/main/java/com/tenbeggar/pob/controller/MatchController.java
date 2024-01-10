package com.tenbeggar.pob.controller;

import com.tenbeggar.pob.controller.dto.MatchDTO;
import com.tenbeggar.pob.controller.dto.MatchStatDTO;
import com.tenbeggar.pob.controller.vo.ChampionRateVO;
import com.tenbeggar.pob.controller.vo.MatchVO;
import com.tenbeggar.pob.service.MatchService;
import com.tenbeggar.pob.utils.PageVO;
import com.tenbeggar.pob.utils.RestVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "对局")
@RestController
@RequestMapping("/match")
public class MatchController {

    @Resource
    private MatchService matchService;

    @Operation(summary = "查询召唤师最近的比赛记录")
    @PostMapping("/record")
    public RestVO<PageVO<MatchVO>> query(@RequestBody MatchDTO matchDTO) {
        PageVO<MatchVO> matchVOS = matchService.pageBySummonerPobId(matchDTO.getSummonerPobId(), matchDTO.getCurrent(), matchDTO.getSize());
        return RestVO.OK(matchVOS);
    }

    @Operation(summary = "查询召唤师最常用的英雄排名")
    @PostMapping("/useChampion")
    public RestVO<List<ChampionRateVO>> useChampion(@RequestBody MatchStatDTO matchStatDTO) {
        List<ChampionRateVO> championRateVOS = matchService.useChampion(matchStatDTO.getSummonerPobId(), matchStatDTO.getTop());
        return RestVO.OK(championRateVOS);
    }

    @Operation(summary = "查询召唤师胜率最高的英雄排名")
    @PostMapping("/winChampion")
    public RestVO<List<ChampionRateVO>> winChampion(@RequestBody MatchStatDTO matchStatDTO) {
        List<ChampionRateVO> championRateVOS = matchService.winChampion(matchStatDTO.getSummonerPobId(), matchStatDTO.getTop());
        return RestVO.OK(championRateVOS);
    }
}
