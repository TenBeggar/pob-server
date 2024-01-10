package com.tenbeggar.pob.controller;

import com.tenbeggar.pob.controller.dto.SummonerDTO;
import com.tenbeggar.pob.controller.vo.SummonerVO;
import com.tenbeggar.pob.service.SummonerService;
import com.tenbeggar.pob.utils.RestVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@Tag(name = "召唤师")
@RestController
@RequestMapping("/summoner")
public class SummonerController {

    @Resource
    private SummonerService summonerService;

    @Operation(summary = "根据名字查询召唤师信息")
    @PostMapping("/byName")
    public RestVO<SummonerVO> byName(@RequestBody SummonerDTO summonerDTO) {
        SummonerVO summonerVO = summonerService.findByRegionAndName(summonerDTO.getRegion(), summonerDTO.getName());
        return RestVO.OK(summonerVO);
    }

    @Operation(summary = "刷新召唤师信息")
    @GetMapping("/refresh/{pobId}")
    public RestVO<SummonerVO> refreshMe(@PathVariable("pobId") String pobId) {
        SummonerVO summonerVO = summonerService.refreshByPobId(pobId);
        return RestVO.OK(summonerVO);
    }
}
