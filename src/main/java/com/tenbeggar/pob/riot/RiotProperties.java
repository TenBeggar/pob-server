package com.tenbeggar.pob.riot;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * The AMERICAS routing value serves NA, BR, LAN and LAS. The ASIA routing value serves KR and JP. The EUROPE routing value serves EUNE, EUW, TR and RU. The SEA routing value serves OCE, PH2, SG2, TH2, TW2 and VN2.
 * LOL游戏常量 https://developer.riotgames.com/docs/lol#working-with-lol-apis_game-constants
 */

@Data
@Component
@ConfigurationProperties(prefix = "riot")
public class RiotProperties {

    private String token;

    private String language;

    private String dragonDir;
}
