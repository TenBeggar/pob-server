package com.tenbeggar.pob.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 游戏类型，详细参考：https://static.developer.riotgames.com/docs/lol/gameTypes.json
 */
@Getter
@AllArgsConstructor
public enum GameTypeEnum {

    CUSTOM_GAME("自定义对局"),
    TUTORIAL_GAME("训练模式，人机模式"),
    MATCHED_GAME("匹配模式"),
    ;

    private final String description;
}
