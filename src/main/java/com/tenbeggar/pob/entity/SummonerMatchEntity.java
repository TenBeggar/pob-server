package com.tenbeggar.pob.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "summoner_match")
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
