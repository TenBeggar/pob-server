package com.tenbeggar.pob.repository;

import com.tenbeggar.pob.entity.ChampionStatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChampionStatsRepository extends JpaRepository<ChampionStatsEntity, String> {
}
