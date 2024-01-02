package com.tenbeggar.pob.repository;

import com.tenbeggar.pob.entity.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<TeamEntity, String> {
}
