package com.tenbeggar.pob.repository;

import com.tenbeggar.pob.entity.BanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BanRepository extends JpaRepository<BanEntity, String> {

    List<BanEntity> findAllByMatchIdAndTeamId(String matchId, Integer teamId);
}
