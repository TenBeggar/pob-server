package com.tenbeggar.pob.riot.domain;

import lombok.Data;

/**
 * 选手信息
 */
@Data
public class Participant {

    //击杀 & 助攻
    private Integer doubleKills;//双杀次数
    private Integer tripleKills;//三杀次数
    private Integer quadraKills;//四杀次数
    private Integer pentaKills;//五杀次数

    private Integer kills;//击杀次数
    private Integer deaths;//死亡次数
    private Integer assists;//助攻次数

    private Boolean firstBloodKill;//是否拿到一血
    private Boolean firstBloodAssist;//是否一血助攻

    private Boolean firstTowerKill;//是否拿到一塔
    private Boolean firstTowerAssist;//是否一塔助攻

    private Integer objectivesStolen;//偷取目标的次数，如偷取对方的红蓝buff
    private Integer objectivesStolenAssists;//偷取目标的助攻次数

    private Integer killingSprees;//大杀特杀的数量，连续击杀三个对手且中途不能死亡
    private Integer largestMultiKill;//一次大杀特杀过程中击杀最多的次数
    private Integer largestKillingSpree;//最多击杀次数，连续击杀对手且中途不能死亡

    private Integer unrealKills;//TODO

    //中立生物 & 小兵
    private Integer dragonKills;//击杀小龙次数
    private Integer baronKills;//击杀男爵次数
    private Integer neutralMinionsKilled;//击杀中立生物的数量
    private Integer totalAllyJungleMinionsKilled;//击杀全部野怪的数量
    private Integer totalEnemyJungleMinionsKilled;//击杀敌方野怪的数量

    private Integer totalMinionsKilled;//击杀小兵的数量

    //防御塔 & 水晶 & 枢纽
    private Integer turretKills;//摧毁防御塔的数量
    private Integer turretTakedowns;//参与摧毁防御塔的数量
    private Integer turretsLost;//丢失防御塔的数量

    private Integer inhibitorKills;//摧毁水晶的数量
    private Integer inhibitorTakedowns;//参与摧毁水晶的数量
    private Integer inhibitorsLost;//丢失水晶的数量

    private Integer nexusKills;//摧毁枢纽的数量
    private Integer nexusTakedowns;//参与摧毁枢纽的数量
    private Integer nexusLost;//丢失枢纽的数量

    //造成的伤害
    private Integer totalDamageDealt;//造成的总伤害
    private Integer physicalDamageDealt;//造成的物理伤害
    private Integer magicDamageDealt;//造成的魔法伤害
    private Integer trueDamageDealt;//造成的真实伤害

    private Integer totalDamageDealtToChampions;//对英雄造成的总伤害
    private Integer physicalDamageDealtToChampions;//对英雄造成的物理伤害
    private Integer magicDamageDealtToChampions;//对英雄造成的魔法伤害
    private Integer trueDamageDealtToChampions;//对英雄造成的真实伤害

    private Integer damageDealtToBuildings;//对建筑物造成的伤害
    private Integer damageDealtToTurrets;//对防御塔造成的伤害
    private Integer damageDealtToObjectives;//对目标造成的伤害

    private Integer timeCCingOthers;//造成法术控制的总时间

    private Integer largestCriticalStrike;//最大暴击伤害

    //承受的伤害
    private Integer totalDamageTaken;//承受的总伤害
    private Integer physicalDamageTaken;//承受的物理伤害
    private Integer magicDamageTaken;//承受的魔法伤害
    private Integer trueDamageTaken;//承受的真实伤害

    private Integer totalTimeCCDealt;//承受法术控制的总时间

    //治疗 & 护盾
    private Integer totalHeal;//总治疗
    private Integer totalHealsOnTeammates;//为对队友提供的总治疗
    private Integer totalUnitsHealed;//治疗的人数

    private Integer totalDamageShieldedOnTeammates;//为队友提供的护盾
    private Integer damageSelfMitigated;//自身伤害减免，包括护盾、减伤害、闪避

    //视野
    private Integer detectorWardsPlaced;//释放扫描的次数
    private Integer wardsKilled;//摧毁视眼的数量
    private Integer wardsPlaced;//放置视眼的数量
    private Integer visionWardsBoughtInGame;//购买假眼的数量
    private Integer sightWardsBoughtInGame;//购买真眼的数量
    private Integer visionScore;//视野评分

    //英雄
    private Integer championId;//英雄id，v11.4版本之前该字段无效，需根据championName确定英雄
    private String championName;//英雄名称
    private Integer champLevel;//英雄等级
    private Integer champExperience;//英雄经验
    private Integer goldEarned;//赚取的金币
    private Integer goldSpent;//花费的金币
    private Integer bountyLevel;//悬赏等级

    private String teamPosition;//位置，队伍必须加入上单、打野、中单等约束，通常情况下teamPosition字段比individualPosition字段推测的更为准确 （比如：TOP.上路 JUNGLE.打野 MIDDLE.中路 BOTTOM.射手 UTILITY.辅助）
    private String individualPosition;//位置，只考虑选手发挥不考虑其他因素 （比如：TOP.上路 JUNGLE.打野 MIDDLE.中路 BOTTOM.射手 UTILITY.辅助）
    private String lane;//道路 NONE
    private String role;//角色 SUPPORT

    private Integer longestTimeSpentLiving;//最长存活时间
    private Integer totalTimeSpentDead;//总死亡时间

    private Integer championTransform;//该字段目前只用于凯隐的变身情况（0.没变身 1.红凯 2.蓝凯）(0 - None, 1 - Slayer, 2 - Assassin)

    //装备 & 技能
    private Integer item0;//装备0
    private Integer item1;//装备1
    private Integer item2;//装备2
    private Integer item3;//装备3
    private Integer item4;//装备4
    private Integer item5;//装备5
    private Integer item6;//装备6

    private Integer consumablesPurchased;//购买消耗品的次数
    private Integer itemsPurchased;//购买装备的次数

    private Integer spell1Casts;//施放Q技能的次数
    private Integer spell2Casts;//施放W技能的次数
    private Integer spell3Casts;//施放E技能的次数
    private Integer spell4Casts;//施放R技能的次数
    private Integer summoner1Casts;//施放D技能的次数
    private Integer summoner1Id;//D技能id
    private Integer summoner2Casts;//施放F技能的次数
    private Integer summoner2Id;//F技能id

    //召唤师
    private Integer participantId;//参与者id

    private String summonerId;//召唤师id
    private String puuid;//召唤师的puuid
    private String summonerName;//召唤师名字
    private Integer summonerLevel;//召唤师等级
    private Integer profileIcon;//召唤师的头像id

    private String riotIdName;//riotId的名字
    private String riotIdTagline;//riotId的标语
    private String riotIdGameName;//riotId的游戏名称

    //团队 & 游戏
    private Integer teamId;//队伍id
    private Boolean teamEarlySurrendered;//团队提前投降
    private Boolean win;//是否胜利

    private Integer timePlayed;//游戏时长
    private Boolean gameEndedInSurrender;//游戏结束于投降
    private Boolean gameEndedInEarlySurrender;//游戏结束于提前投降

    private Integer placement;//定位赛
    private Integer subteamPlacement;//小队定位赛
    private Boolean eligibleForProgression;//是否晋级

    //ping信号的次数
    private Integer allInPings;//总次数
    private Integer commandPings;//标记信号
    private Integer basicPings;//G-信号
    private Integer getBackPings;//撤退
    private Integer pushPings;//推进
    private Integer onMyWayPings;//正在路上
    private Integer holdPings;//全力进攻
    private Integer assistMePings;//协助我
    private Integer needVisionPings;//需要视野
    private Integer enemyMissingPings;//敌人消失
    private Integer enemyVisionPings;//敌方视野
    private Integer dangerPings;//V-谨慎行事

    private Integer visionClearedPings;//清除视野
    private Integer baitPings;//诱饵

    private Integer playerAugment1;//TODO
    private Integer playerAugment2;
    private Integer playerAugment3;
    private Integer playerAugment4;

    private Integer playerSubteamId;

    //    private Mission missions;//TODO
//    private Challenge challenges;//勋章
    private Perk perks;//天赋选择
}
