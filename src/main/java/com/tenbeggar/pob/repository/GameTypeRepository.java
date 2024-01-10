package com.tenbeggar.pob.repository;

import com.tenbeggar.pob.entity.GameTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameTypeRepository extends JpaRepository<GameTypeEntity, String> {
}
