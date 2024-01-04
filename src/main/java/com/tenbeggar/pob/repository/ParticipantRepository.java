package com.tenbeggar.pob.repository;

import com.tenbeggar.pob.entity.ParticipantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParticipantRepository extends JpaRepository<ParticipantEntity, String> {

    List<ParticipantEntity> findAllByMatchId(String matchId);
}
