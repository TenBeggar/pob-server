package com.tenbeggar.pob.riot;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * LOL游戏常量 https://developer.riotgames.com/docs/lol#data-dragon
 */

@Data
@Component
@ConfigurationProperties(prefix = "riot")
public class RiotProperties {

    private String token;

    private String language;

    private String dragonPath;
}
