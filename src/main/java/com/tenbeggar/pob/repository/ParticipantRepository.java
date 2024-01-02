package com.tenbeggar.pob.repository;

import com.tenbeggar.pob.entity.ParticipantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<ParticipantEntity, String> {
}
