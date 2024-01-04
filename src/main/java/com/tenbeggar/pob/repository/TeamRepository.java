package com.tenbeggar.pob.repository;

import com.tenbeggar.pob.entity.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository<TeamEntity, String> {

    List<TeamEntity> findAllByMatchId(String matchId);
}
