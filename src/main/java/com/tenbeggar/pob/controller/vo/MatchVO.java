package com.tenbeggar.pob.controller.vo;

import com.tenbeggar.pob.properties.GameMode;
import com.tenbeggar.pob.properties.GameType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Schema(description = "比赛记录")
@Data
public class MatchVO {

    @Schema(description = "对局id")
    public String matchId;
    @Schema(description = "数据版本")
    public String dataVersion;
    @Schema(description = "游戏版本")
    public String gameVersion;
    @Schema(description = "游戏创建时间")
    public Long gameCreation;
    @Schema(description = "游戏开始时间")
    public Long gameStartTimestamp;
    @Schema(description = "游戏结束时间，2021年10月5日v11.20版本后支持")
    public Long gameEndTimestamp;
    @Schema(description = "游戏时长，2021年10月5日v11.20版本前以毫秒为单位，之后以秒为单位。若game_end_timestamp不存在视为毫秒，存在视为秒。")
    public Long gameDuration;
    @Schema(description = "游戏id")
    public Long gameId;
    @Schema(description = "游戏名称")
    public String gameName;
    @Schema(description = "对局类型id（匹配、单双排、五排、大乱斗等）")
    public Integer queueId;
    @Schema(description = "游戏模式：CLASSIC.召唤师峡谷或扭曲丛林 ODIN.水晶之痕，5V5占领水晶获得积分，先得500积分的队伍获胜 ARAM.极地大乱斗 TUTORIAL.新手教程，训练场 URF.召唤师峡谷.无限火力 DOOMBOTSTEEMO.召唤师峡谷.末日人机 ONEFORALL.召唤师峡谷.克隆模式 ASCENSION.水晶之痕.飞升模式，5v5杀死中立生物泽拉斯的玩家获得巨大战力提升 FIRSTBLOOD.嚎哭深渊.一血模式 KINGPORO.极地大乱斗.魄罗王模式 SIEGE.召唤师峡谷.机械攻城模式，5v5分蓝方为攻城方，红方为防守方，双方有特殊的召唤师技能 ASSASSINATE.召唤师峡谷.血腥狩猎模式，5v5每次击杀获得1层狩猎值，3层后消耗所有狩猎值进入隐身状态 ARSR.召唤师峡谷.随机模式 DARKSTAR.宇宙废墟.暗星，玩家锤石5V5将对手Q或E进黑洞获取积分，先得100积分的队伍获胜 STARGUARDIAN.星际守护者入侵(PVE)，5个玩家阻止虚空入侵，最后消灭峡谷先锋的模式 PROJECT.PROJECT: Hunters games GAMEMODEX.Nexus Blitz games ODYSSEY.奥德赛.夺萃之镰(PVE)，5个玩家最终消灭BOSS凯影 NEXUSBLITZ.极限闪击，5V5击毁对方水晶获胜，特定时间进入火圈比赛，获胜方战力提升，有野怪或者魄罗王帮助 ULTBOOK.召唤师峡谷.终极魔典，开局3选1其他英雄的大招为召唤师技能 CHERRY.樱花模式，特定节日推出，游戏的地图和角色外观有特别设计")
    public GameMode gameMode;
    @Schema(description = "游戏类型：CUSTOM_GAME.自定义对局 TUTORIAL_GAME.训练模式，人机模式 MATCHED_GAME.匹配模式")
    public GameType gameType;
    @Schema(description = "地图id")
    public Integer mapId;
    @Schema(description = "对局平台id")
    public String platformId;
    @Schema(description = "锦标赛code")
    public String tournamentCode;
    @Schema(description = "队伍信息")
    public List<TeamVO> teams;
    @Schema(description = "选手信息")
    public List<ParticipantVO> participants;
}
