package com.tenbeggar.pob.repository;

import com.tenbeggar.pob.entity.ObjectiveEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ObjectiveRepository extends JpaRepository<ObjectiveEntity, String> {

    List<ObjectiveEntity> findAllByMatchIdAndTeamId(String matchId, Integer teamId);
}
