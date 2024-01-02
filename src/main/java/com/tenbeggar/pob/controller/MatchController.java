package com.tenbeggar.pob.controller;

import com.tenbeggar.pob.controller.dto.MatchDTO;
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

@Tag(name = "对局")
@RestController
@RequestMapping("/match")
public class MatchController {

    @Resource
    private MatchService matchService;

    @Operation(summary = "根据召唤师pobId查询他最近的比赛记录")
    @PostMapping
    public RestVO<PageVO<MatchVO>> query(@RequestBody MatchDTO matchDTO) {
        PageVO<MatchVO> matchVOS = matchService.pageBySummonerPobId(matchDTO.getSummonerPobId(), matchDTO.getCurrent(), matchDTO.getSize());
        return RestVO.OK(matchVOS);
    }
}
