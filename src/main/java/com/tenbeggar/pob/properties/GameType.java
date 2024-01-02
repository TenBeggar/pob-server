package com.tenbeggar.pob.properties;

/**
 * 游戏类型，详细参考：https://static.developer.riotgames.com/docs/lol/gameTypes.json
 */
public enum GameType {

    /**
     * 自定义对局
     */
    CUSTOM_GAME,

    /**
     * 训练模式，人机模式
     */
    TUTORIAL_GAME,

    /**
     * 匹配模式
     */
    MATCHED_GAME,
    ;
}
