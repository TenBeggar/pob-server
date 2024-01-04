package com.tenbeggar.pob.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 对局类型，详细参考：https://static.developer.riotgames.com/docs/lol/queues.json
 */
@Getter
@AllArgsConstructor
public enum Queue {

    CUSTOM(0, "召唤师峡谷|嚎哭深渊", "自定义模式"),
    HOWLING_ABYSS_1V1(72, "嚎哭深渊", "嚎哭深渊1V1模式"),
    HOWLING_ABYSS_2V2(73, "嚎哭深渊", "嚎哭深渊2V2模式"),
    SUMMONER_RIFT_6V6(75, "召唤师峡谷", "召唤师峡谷6杀模式"),
    SUMMONER_RIFT_URF(76, "召唤师峡谷", "无限火力"),
    HOWLING_ABYSS_COPY(78, "嚎哭深渊", "嚎哭深渊克隆模式"),
    SUMMONER_RIFT_URF_AI(83, "召唤师峡谷", "人机无限火力模式"),
    TWISTED_TREELINE_6V6(98, "扭曲丛林", "扭曲丛林6杀模式"),
    BUTCHER_BRIDGE(100, "屠夫之桥", "屠夫之桥"),
    SUMMONER_RIFT_NEMESIS(310, "召唤师峡谷", "复仇模式，击杀上次杀死你的对手可获得额外奖励"),
    SUMMONER_RIFT_BLACK_MARKET(313, "召唤师峡谷", "黑市乱斗游戏，商店贩卖可升级的装备"),
    CRYSTAL_SCAR(317, "水晶之痕", "水晶之痕"),
    SUMMONER_RIFT_RANDOM(325, "召唤师峡谷", "随机模式"),
    SUMMONER_RIFT_PICK_5V5(400, "召唤师峡谷", "召唤师峡谷5V5自选模式"),
    SUMMONER_RIFT_RANK_SOLO(420, "召唤师峡谷", "召唤师峡谷单双排"),
    SUMMONER_RIFT_BLIND_5V5(430, "召唤师峡谷", "召唤师峡谷5V5盲选模式"),
    SUMMONER_RIFT_RANK_FLEX(440, "召唤师峡谷", "召唤师峡谷灵活组排"),
    HOWLING_ABYSS(450, "嚎哭深渊", "嚎哭深渊"),
    SUMMONER_RIFT_QUICKPLAY(490, "召唤师峡谷", "正常(快速播放)"),
    SUMMONER_RIFT_ASSASSINATE(600, "召唤师峡谷", "血腥狩猎模式"),
    DARKSTAR(610, "宇宙废墟", "宇宙废墟.暗星"),
    SUMMONER_RIFT_CLASH(700, "召唤师峡谷", "召唤师峡谷冲突模式，玩家可选择团队（LOGO）"),
    HOWLING_ABYSS_CLASH(720, "嚎哭深渊", "嚎哭深渊冲突模式"),
    HOWLING_ABYSS_BEGINNER_AI(820, "扭曲丛林", "扭曲丛林初级人机"),
    SUMMONER_RIFT_INTRO_AI(830, "召唤师峡谷", "召唤师峡谷介绍人机"),
    SUMMONER_RIFT_BEGINNER_AI(840, "召唤师峡谷", "召唤师峡谷初级人机"),
    SUMMONER_RIFT_INTERMEDIATE_AI(850, "召唤师峡谷", "召唤师峡谷中级人机"),
    SUMMONER_RIFT_ARURF(900, "召唤师峡谷", "无限火力随机模式"),
    CRYSTAL_SCAR_ASCENSION(910, "水晶之痕", "水晶之痕飞升模式"),
    HOWLING_ABYSS_KINGPORO(920, "嚎哭深渊", "嚎哭深渊魄罗王模式"),
    SUMMONER_RIFT_SIEGE(940, "召唤师峡谷", "机械攻城模式"),
    SUMMONER_RIFT_VOTING_DOOMBOTSTEEMO(950, "召唤师峡谷", "末日人机投票模式"),
    SUMMONER_RIFT_DOOMBOTSTEEMO(960, "召唤师峡谷", "末日人机标准模式"),
    STARGUARDIAN(980, "瓦洛兰城市公园", "星际守护者入侵：正常模式"),
    STARGUARDIAN_ONSLAUGHT(990, "瓦洛兰城市公园", "星际守护者入侵：猛攻模式"),
    PROJECT(1000, "过度充能", "项目：猎人游戏"),
    SUMMONER_RIFT_SNOW_ARURF(1010, "召唤师峡谷", "无限火力随机模式（雪景）"),
    SUMMONER_RIFT_COPY(1020, "召唤师峡谷", "召唤师峡谷克隆模式"),
    ODYSSEY_INTRO(1030, "坠毁之地", "奥德赛.夺萃之镰：简介游戏"),
    ODYSSEY_CADET(1040, "坠毁之地", "奥德赛.夺萃之镰：学员游戏"),
    ODYSSEY_CREWMEMBER(1050, "坠毁之地", "奥德赛.夺萃之镰：船员游戏"),
    ODYSSEY_CAPTAIN(1060, "坠毁之地", "奥德赛.夺萃之镰：船长游戏"),
    ODYSSEY_ONSLAUGHT(1070, "坠毁之地", "奥德赛.夺萃之镰：猛攻游戏"),
    CONVERGENCE(1090, "云顶之弈", "云顶之弈匹配局"),
    CONVERGENCE_TACTICS(1100, "云顶之弈", "云顶之弈排位赛"),
    CONVERGENCE_TUTORIAL(1110, "云顶之弈", "云顶之弈教程局"),
    CONVERGENCE_TEST(1111, "云顶之弈", "云顶之弈测试局"),
    NEXUSBLITZ(1300, "极限闪击", "极限闪击"),
    SUMMONER_RIFT_ULTBOOK(1400, "召唤师峡谷", "终极魔典"),
    RINGS_OF_WRATH(1700, "愤怒之环", "斗魂竞技场"),
    SUMMONER_RIFT_PICK_URF(1900, "召唤师峡谷", "无限火力自选模式"),
    SUMMONER_RIFT_TUTORIAL1(2000, "召唤师峡谷", "召唤师峡谷教程1"),
    SUMMONER_RIFT_TUTORIAL2(2010, "召唤师峡谷", "召唤师峡谷教程2"),
    SUMMONER_RIFT_TUTORIAL3(2020, "召唤师峡谷", "召唤师峡谷教程3"),
    ;

    private final int id;
    private final String map;
    private final String description;
}
 
