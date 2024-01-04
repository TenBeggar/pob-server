package com.tenbeggar.pob.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "summoner_match", uniqueConstraints = @UniqueConstraint(columnNames = {"puuid", "matchId"}))
public class SummonerMatchEntity extends BaseEntity {

    /**
     * SummonerEntity -> puuid
     */
    public String puuid;

    /**
     * MatchEntity -> matchId
     */
    public String matchId;
}
