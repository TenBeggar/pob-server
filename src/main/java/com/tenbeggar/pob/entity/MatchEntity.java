package com.tenbeggar.pob.entity;

import com.tenbeggar.pob.properties.GameMode;
import com.tenbeggar.pob.properties.GameType;
import com.tenbeggar.pob.riot.domain.MatchMetadata;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 对局详情
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "match")
public class MatchEntity extends BaseEntity {

    /**
     * 游戏版本
     */
    public String gameVersion;

    /**
     * 游戏创建时间
     */
    public Long gameCreation;

    /**
     * 游戏开始时间
     */
    public Long gameStartTimestamp;

    /**
     * 游戏结束时间，2021年10月5日v11.20版本后支持
     */
    public Long gameEndTimestamp;

    /**
     * 游戏时长，2021年10月5日v11.20版本前以毫秒为单位，之后以秒为单位。若game_end_timestamp不存在视为毫秒，存在视为秒。
     */
    public Long gameDuration;

    /**
     * 游戏id
     */
    public Long gameId;

    /**
     * 游戏名称
     */
    public String gameName;

    /**
     * 对局类型id（匹配、单双排、五排、大乱斗等），详情参考：https://static.developer.riotgames.com/docs/lol/queues.json
     */
    public Integer queueId;

    /**
     * 游戏模式
     */
    @Enumerated(value = EnumType.STRING)
    public GameMode gameMode;

    /**
     * 游戏类型，详细参考：https://static.developer.riotgames.com/docs/lol/gameTypes.json
     */
    @Enumerated(value = EnumType.STRING)
    public GameType gameType;

    /**
     * 地图id，详细参考：https://static.developer.riotgames.com/docs/lol/maps.json
     */
    public Integer mapId;

    /**
     * 对局平台id
     */
    public String platformId;

    /**
     * 锦标赛code
     */
    public String tournamentCode;

    /**
     * 冗余字段，对局id
     */
    public String matchId;

    /**
     * 冗余字段，数据版本
     */
    public String dataVersion;

    /**
     * 填充冗余字段
     */
    public void fill(MatchMetadata metadata) {
        this.setMatchId(metadata.getMatchId());
        this.setDataVersion(metadata.getDataVersion());
    }
}
