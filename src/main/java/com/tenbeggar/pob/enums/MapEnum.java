package com.tenbeggar.pob.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 地图id，详细参考：https://static.developer.riotgames.com/docs/lol/maps.json
 */
@Getter
@AllArgsConstructor
public enum MapEnum {

    SUMMONER_RIFT_SUMMER(1, "召唤师峡谷（夏季）", "召唤师峡谷（夏季）"),
    SUMMONER_RIFT_AUTUMN(2, "召唤师峡谷（秋季）", "召唤师峡谷（秋季）"),
    THE_PROVING_GROUNDS(3, "新手教程，训练场", "新手教程，训练场"),
    TWISTED_TREELINE(4, "扭曲丛林", "扭曲丛林，3V3击毁对方水晶获胜"),
    THE_CRYSTAL_SCAR(8, "水晶之痕", "水晶之痕，5V5占领水晶获得积分，先得500积分的队伍获胜"),
    TWISTED_TREELINE_TT(10, "扭曲丛林", "扭曲丛林，最后临时版本"),
    SUMMONER_RIFT(11, "召唤师峡谷", "召唤师峡谷"),
    HOWLING_ABYSS(12, "嚎哭深渊", "嚎哭深渊，ARAM地图"),
    BUTCHER_BRIDGE(14, "屠夫之桥", "屠夫之桥，备用ARAM地图"),
    COSMIC_RUINS(16, "宇宙废墟.暗星", "宇宙废墟.暗星，玩家锤石5V5将对手Q或E进黑洞获取积分，先得100积分的队伍获胜"),
    VALORAN_CITY_PARK(18, "瓦洛兰城市公园", "瓦洛兰城市公园(PVE)，5个玩家阻止虚空入侵，最后消灭峡谷先锋的模式"),
    SUBSTRUCTURE_43(19, "43号建筑", "43号建筑，3V3击杀对手获取积分，先得100积分的队伍获胜，通过充能提升战力"),
    CRASH_SITE(20, "奥德赛.夺萃之镰", "奥德赛.夺萃之镰(PVE)，5个玩家最终消灭BOSS凯影"),
    NEXUS_BLITZ(21, "极限闪击", "极限闪击，5V5击毁对方水晶获胜，特定时间进入火圈比赛，获胜方战力提升，有野怪或者魄罗王帮助"),
    CONVERGENCE(22, "云顶之弈", "云顶之弈"),
    RINGS_OF_WRATH(30, "斗魂竞技场", "斗魂竞技场，2V2V2V2 开局100血，通过抽牌提升战力，最终活下来的队伍获胜"),
    ;

    private final int id;
    private final String name;
    private final String description;
}
