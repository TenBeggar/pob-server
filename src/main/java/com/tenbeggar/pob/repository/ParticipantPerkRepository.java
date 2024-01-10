package com.tenbeggar.pob.repository;

import com.tenbeggar.pob.entity.ParticipantPerkEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParticipantPerkRepository extends JpaRepository<ParticipantPerkEntity, String> {

    List<ParticipantPerkEntity> findAllByMatchIdAndParticipantId(String matchId, Integer participantId);
}
