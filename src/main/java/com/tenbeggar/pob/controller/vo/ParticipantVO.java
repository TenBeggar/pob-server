package com.tenbeggar.pob.controller.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "选手信息")
@Data
public class ParticipantVO {

    //击杀 & 助攻
    @Schema(description = "双杀次数")
    private Integer doubleKills;
    @Schema(description = "三杀次数")
    private Integer tripleKills;
    @Schema(description = "四杀次数")
    private Integer quadraKills;
    @Schema(description = "五杀次数")
    private Integer pentaKills;

    @Schema(description = "击杀次数")
    private Integer kills;
    @Schema(description = "死亡次数")
    private Integer deaths;
    @Schema(description = "助攻次数")
    private Integer assists;

    @Schema(description = "是否拿到一血")
    private Boolean firstBloodKill;
    @Schema(description = "是否一血助攻")
    private Boolean firstBloodAssist;

    @Schema(description = "是否拿到一塔")
    private Boolean firstTowerKill;
    @Schema(description = "是否一塔助攻")
    private Boolean firstTowerAssist;

    @Schema(description = "偷取目标的次数，如偷取对方的红蓝buff")
    private Integer objectivesStolen;
    @Schema(description = "偷取目标的助攻次数")
    private Integer objectivesStolenAssists;

    @Schema(description = "大杀特杀的数量，连续击杀三个对手且中途不能死亡")
    private Integer killingSprees;
    @Schema(description = "一次大杀特杀过程中击杀最多的次数")
    private Integer largestMultiKill;
    @Schema(description = "最多击杀次数，连续击杀对手且中途不能死亡")
    private Integer largestKillingSpree;

    private Integer unrealKills;//TODO

    //中立生物 & 小兵
    @Schema(description = "击杀小龙次数")
    private Integer dragonKills;
    @Schema(description = "击杀男爵次数")
    private Integer baronKills;
    @Schema(description = "击杀中立生物的数量")
    private Integer neutralMinionsKilled;
    @Schema(description = "击杀全部野怪的数量")
    private Integer totalAllyJungleMinionsKilled;
    @Schema(description = "击杀敌方野怪的数量")
    private Integer totalEnemyJungleMinionsKilled;

    @Schema(description = "击杀小兵的数量")
    private Integer totalMinionsKilled;

    //防御塔 & 水晶 & 枢纽
    @Schema(description = "摧毁防御塔的数量")
    private Integer turretKills;
    @Schema(description = "参与摧毁防御塔的数量")
    private Integer turretTakedowns;
    @Schema(description = "丢失防御塔的数量")
    private Integer turretsLost;

    @Schema(description = "摧毁水晶的数量")
    private Integer inhibitorKills;
    @Schema(description = "参与摧毁水晶的数量")
    private Integer inhibitorTakedowns;
    @Schema(description = "丢失水晶的数量")
    private Integer inhibitorsLost;

    @Schema(description = "摧毁枢纽的数量")
    private Integer nexusKills;
    @Schema(description = "参与摧毁枢纽的数量")
    private Integer nexusTakedowns;
    @Schema(description = "丢失枢纽的数量")
    private Integer nexusLost;

    //造成的伤害
    @Schema(description = "造成的总伤害")
    private Integer totalDamageDealt;
    @Schema(description = "造成的物理伤害")
    private Integer physicalDamageDealt;
    @Schema(description = "造成的魔法伤害")
    private Integer magicDamageDealt;
    @Schema(description = "造成的真实伤害")
    private Integer trueDamageDealt;

    @Schema(description = "对英雄造成的总伤害")
    private Integer totalDamageDealtToChampions;
    @Schema(description = "对英雄造成的物理伤害")
    private Integer physicalDamageDealtToChampions;
    @Schema(description = "对英雄造成的魔法伤害")
    private Integer magicDamageDealtToChampions;
    @Schema(description = "对英雄造成的真实伤害")
    private Integer trueDamageDealtToChampions;

    @Schema(description = "对建筑物造成的伤害")
    private Integer damageDealtToBuildings;
    @Schema(description = "对防御塔造成的伤害")
    private Integer damageDealtToTurrets;
    @Schema(description = "对目标造成的伤害")
    private Integer damageDealtToObjectives;

    @Schema(description = "造成法术控制的总时间")
    private Integer timeCCingOthers;

    @Schema(description = "最大暴击伤害")
    private Integer largestCriticalStrike;

    //承受的伤害
    @Schema(description = "承受的总伤害")
    private Integer totalDamageTaken;
    @Schema(description = "承受的物理伤害")
    private Integer physicalDamageTaken;
    @Schema(description = "承受的魔法伤害")
    private Integer magicDamageTaken;
    @Schema(description = "承受的真实伤害")
    private Integer trueDamageTaken;

    @Schema(description = "承受法术控制的总时间")
    private Integer totalTimeCCDealt;

    //治疗 & 护盾
    @Schema(description = "总治疗")
    private Integer totalHeal;
    @Schema(description = "为对队友提供的总治疗")
    private Integer totalHealsOnTeammates;
    @Schema(description = "治疗的人数")
    private Integer totalUnitsHealed;

    @Schema(description = "为队友提供的护盾")
    private Integer totalDamageShieldedOnTeammates;
    @Schema(description = "自身伤害减免，包括护盾、减伤害、闪避")
    private Integer damageSelfMitigated;

    //视野
    @Schema(description = "释放扫描的次数")
    private Integer detectorWardsPlaced;
    @Schema(description = "摧毁视眼的数量")
    private Integer wardsKilled;
    @Schema(description = "放置视眼的数量")
    private Integer wardsPlaced;
    @Schema(description = "购买假眼的数量")
    private Integer visionWardsBoughtInGame;
    @Schema(description = "购买真眼的数量")
    private Integer sightWardsBoughtInGame;
    @Schema(description = "视野评分")
    private Integer visionScore;

    //英雄
    @Schema(description = "英雄id，v11.4版本之前该字段无效，需根据championName确定英雄")
    private Integer championId;
    @Schema(description = "英雄名称")
    private String championName;
    @Schema(description = "英雄等级")
    private Integer champLevel;
    @Schema(description = "英雄经验")
    private Integer champExperience;
    @Schema(description = "赚取的金币")
    private Integer goldEarned;
    @Schema(description = "花费的金币")
    private Integer goldSpent;
    @Schema(description = "悬赏等级")
    private Integer bountyLevel;

    @Schema(description = "位置，队伍必须加入上单、打野、中单等约束，通常情况下teamPosition字段比individualPosition字段推测的更为准确 （比如：TOP.上路 JUNGLE.打野 MIDDLE.中路 BOTTOM.射手 UTILITY.辅助）")
    private String teamPosition;
    @Schema(description = "位置，只考虑选手发挥不考虑其他因素 （比如：TOP.上路 JUNGLE.打野 MIDDLE.中路 BOTTOM.射手 UTILITY.辅助）")
    private String individualPosition;
    @Schema(description = "道路 NONE")
    private String lane;
    @Schema(description = "角色 SUPPORT")
    private String role;

    @Schema(description = "最长存活时间")
    private Integer longestTimeSpentLiving;
    @Schema(description = "总死亡时间")
    private Integer totalTimeSpentDead;

    @Schema(description = "该字段目前只用于凯隐的变身情况（0.没变身 1.红凯 2.蓝凯）(0 - None, 1 - Slayer, 2 - Assassin)")
    private Integer championTransform;

    //装备 & 技能
    @Schema(description = "装备0")
    private Integer item0;
    @Schema(description = "装备1")
    private Integer item1;
    @Schema(description = "装备2")
    private Integer item2;
    @Schema(description = "装备3")
    private Integer item3;
    @Schema(description = "装备4")
    private Integer item4;
    @Schema(description = "装备5")
    private Integer item5;
    @Schema(description = "装备6")
    private Integer item6;

    @Schema(description = "购买消耗品的次数")
    private Integer consumablesPurchased;
    @Schema(description = "购买装备的次数")
    private Integer itemsPurchased;

    @Schema(description = "施放Q技能的次数")
    private Integer spell1Casts;
    @Schema(description = "施放W技能的次数")
    private Integer spell2Casts;
    @Schema(description = "施放E技能的次数")
    private Integer spell3Casts;
    @Schema(description = "施放R技能的次数")
    private Integer spell4Casts;
    @Schema(description = "施放D技能的次数")
    private Integer summoner1Casts;
    @Schema(description = "D技能id")
    private Integer summoner1Id;
    @Schema(description = "施放F技能的次数")
    private Integer summoner2Casts;
    @Schema(description = "F技能id")
    private Integer summoner2Id;

    //召唤师
    @Schema(description = "参与者id")
    private Integer participantId;

    @Schema(description = "召唤师id")
    private String summonerId;
    @Schema(description = "召唤师的puuid")
    private String puuid;
    @Schema(description = "召唤师名字")
    private String summonerName;
    @Schema(description = "召唤师等级")
    private Integer summonerLevel;
    @Schema(description = "召唤师的头像id")
    private Integer profileIcon;

    @Schema(description = "riotId的名字")
    private String riotIdName;
    @Schema(description = "riotId的标语")
    private String riotIdTagline;
    @Schema(description = "riotId的游戏名称")
    private String riotIdGameName;

    //团队 & 游戏
    @Schema(description = "队伍id")
    private Integer teamId;
    @Schema(description = "团队提前投降")
    private Boolean teamEarlySurrendered;
    @Schema(description = "是否胜利")
    private Boolean win;

    @Schema(description = "游戏时长")
    private Integer timePlayed;
    @Schema(description = "游戏结束于投降")
    private Boolean gameEndedInSurrender;
    @Schema(description = "游戏结束于提前投降")
    private Boolean gameEndedInEarlySurrender;

    @Schema(description = "定位赛")
    private Integer placement;
    @Schema(description = "小队定位赛")
    private Integer subteamPlacement;
    @Schema(description = "是否晋级")
    private Boolean eligibleForProgression;

    //ping信号的次数
    @Schema(description = "总次数")
    private Integer allInPings;
    @Schema(description = "标记信号")
    private Integer commandPings;
    @Schema(description = "G-信号")
    private Integer basicPings;
    @Schema(description = "撤退")
    private Integer getBackPings;
    @Schema(description = "推进")
    private Integer pushPings;
    @Schema(description = "正在路上")
    private Integer onMyWayPings;
    @Schema(description = "全力进攻")
    private Integer holdPings;
    @Schema(description = "协助我")
    private Integer assistMePings;
    @Schema(description = "需要视野")
    private Integer needVisionPings;
    @Schema(description = "敌人消失")
    private Integer enemyMissingPings;
    @Schema(description = "敌方视野")
    private Integer enemyVisionPings;
    @Schema(description = "V-谨慎行事")
    private Integer dangerPings;

    @Schema(description = "清除视野")
    private Integer visionClearedPings;
    @Schema(description = "诱饵")
    private Integer baitPings;
}
