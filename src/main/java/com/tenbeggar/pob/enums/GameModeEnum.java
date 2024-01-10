package com.tenbeggar.pob.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 游戏模式，详情参考：https://static.developer.riotgames.com/docs/lol/gameModes.json
 */
@Getter
@AllArgsConstructor
public enum GameModeEnum {

    CLASSIC("召唤师峡谷或扭曲丛林", "召唤师峡谷或扭曲丛林"),
    ODIN("水晶之痕", "水晶之痕，5V5占领水晶获得积分，先得500积分的队伍获胜"),
    ARAM("极地大乱斗", "极地大乱斗"),
    TUTORIAL("新手教程，训练场", "新手教程，训练场"),
    URF("无限火力", "召唤师峡谷.无限火力"),
    DOOMBOTSTEEMO("末日人机", "召唤师峡谷.末日人机"),
    ONEFORALL("克隆模式", "召唤师峡谷.克隆模式"),
    ASCENSION("飞升模式", "水晶之痕.飞升模式，5v5杀死中立生物泽拉斯的玩家获得巨大战力提升"),
    FIRSTBLOOD("嚎哭深渊.一血模式", "嚎哭深渊.一血模式"),
    KINGPORO("魄罗王模式", "极地大乱斗.魄罗王模式"),
    SIEGE("机械攻城模式", "召唤师峡谷.机械攻城模式，5v5分蓝方为攻城方，红方为防守方，双方有特殊的召唤师技能"),
    ASSASSINATE("血腥狩猎模式", "召唤师峡谷.血腥狩猎模式，5v5每次击杀获得1层狩猎值，3层后消耗所有狩猎值进入隐身状态"),
    ARSR("随机模式", "召唤师峡谷.随机模式"),
    DARKSTAR("宇宙废墟.暗星", "宇宙废墟.暗星，玩家锤石5V5将对手Q或E进黑洞获取积分，先得100积分的队伍获胜"),
    STARGUARDIAN("星际守护者入侵", "星际守护者入侵(PVE)，5个玩家阻止虚空入侵，最后消灭峡谷先锋的模式"),
    PROJECT("PROJECT", "PROJECT: Hunters games"),
    GAMEMODEX("GAMEMODEX", "Nexus Blitz games"),
    ODYSSEY("奥德赛.夺萃之镰", "奥德赛.夺萃之镰(PVE)，5个玩家最终消灭BOSS凯影"),
    NEXUSBLITZ("极限闪击", "极限闪击，5V5击毁对方水晶获胜，特定时间进入火圈比赛，获胜方战力提升，有野怪或者魄罗王帮助"),
    ULTBOOK("终极魔典", "召唤师峡谷.终极魔典，开局3选1其他英雄的大招为召唤师技能"),
    //注意：官方给出的gameModes.json没有，但实际情况会有
    CHERRY("樱花模式", "樱花模式，特定节日推出，游戏的地图和角色外观有特别设计"),
    ;

    private final String name;
    private final String description;
}
