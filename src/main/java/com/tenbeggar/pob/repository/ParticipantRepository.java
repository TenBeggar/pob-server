package com.tenbeggar.pob.repository;

import com.tenbeggar.pob.controller.vo.ChampionRateVO;
import com.tenbeggar.pob.entity.ParticipantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ParticipantRepository extends JpaRepository<ParticipantEntity, String> {

    List<ParticipantEntity> findAllByMatchId(String matchId);

    @Query(value = "SELECT new com.tenbeggar.pob.controller.vo.ChampionRateVO(championId as championId, SUM(CAST(win AS INTEGER)) AS totalWins, COUNT(*) AS totalGames, (SUM(CAST(win AS INTEGER)) * 100.0 / COUNT(*)) AS winRate) " +
            "FROM ParticipantEntity WHERE puuid = :puuid " +
            "GROUP BY championId " +
            "ORDER BY totalGames DESC " +
            "LIMIT :top ")
    List<ChampionRateVO> useChampion(@Param("puuid") String puuid, @Param("top") Integer top);

    @Query(value = "SELECT new com.tenbeggar.pob.controller.vo.ChampionRateVO(championId as championId, SUM(CAST(win AS INTEGER)) AS totalWins, COUNT(*) AS totalGames, (SUM(CAST(win AS INTEGER)) * 100.0 / COUNT(*)) AS winRate) " +
            "FROM ParticipantEntity WHERE puuid = :puuid " +
            "GROUP BY championId " +
            "ORDER BY winRate DESC " +
            "LIMIT :top ")
    List<ChampionRateVO> winChampion(@Param("puuid") String puuid, @Param("top") Integer top);
}
