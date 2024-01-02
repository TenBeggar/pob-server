package com.tenbeggar.pob.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 地图id，详细参考：https://static.developer.riotgames.com/docs/lol/maps.json
 */
@Getter
@AllArgsConstructor
public enum Map {

    /**
     * 召唤师峡谷（夏季）
     */
    SUMMONER_RIFT_SUMMER(1),

    /**
     * 召唤师峡谷（秋季）
     */
    SUMMONER_RIFT_AUTUMN(2),

    /**
     * 新手教程，训练场
     */
    THE_PROVING_GROUNDS(3),

    /**
     * 扭曲丛林，3V3击毁对方水晶获胜
     */
    TWISTED_TREELINE(4),

    /**
     * 水晶之痕，5V5占领水晶获得积分，先得500积分的队伍获胜
     */
    THE_CRYSTAL_SCAR(8),

    /**
     * 扭曲丛林，最后临时版本
     */
    TWISTED_TREELINE_TT(10),

    /**
     * 召唤师峡谷
     */
    SUMMONER_RIFT(11),

    /**
     * 嚎哭深渊，ARAM地图
     */
    HOWLING_ABYSS(12),

    /**
     * 屠夫之桥，备用ARAM地图
     */
    BUTCHER_BRIDGE(14),

    /**
     * 宇宙废墟.暗星，玩家锤石5V5将对手Q或E进黑洞获取积分，先得100积分的队伍获胜
     */
    COSMIC_RUINS(16),

    /**
     * 瓦洛兰城市公园(PVE)，5个玩家阻止虚空入侵，最后消灭峡谷先锋的模式
     */
    VALORAN_CITY_PARK(18),

    /**
     * 43号建筑，3V3击杀对手获取积分，先得100积分的队伍获胜，通过充能提升战力
     */
    SUBSTRUCTURE_43(19),

    /**
     * 奥德赛.夺萃之镰(PVE)，5个玩家最终消灭BOSS凯影
     */
    CRASH_SITE(20),

    /**
     * 极限闪击，5V5击毁对方水晶获胜，特定时间进入火圈比赛，获胜方战力提升，有野怪或者魄罗王帮助
     */
    NEXUS_BLITZ(21),

    /**
     * 云顶之弈
     */
    CONVERGENCE(22),

    /**
     * 斗魂竞技场，2V2V2V2 开局100血，通过抽牌提升战力，最终活下来的队伍获胜
     */
    RINGS_OF_WRATH(30),
    ;

    private final int id;
}
