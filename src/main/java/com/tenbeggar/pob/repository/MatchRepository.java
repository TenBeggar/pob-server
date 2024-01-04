package com.tenbeggar.pob.repository;

import com.tenbeggar.pob.entity.MatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatchRepository extends JpaRepository<MatchEntity, String> {

    MatchEntity findByMatchId(String matchId);

    List<MatchEntity> findAllByMatchIdIn(List<String> matchIds);
}
