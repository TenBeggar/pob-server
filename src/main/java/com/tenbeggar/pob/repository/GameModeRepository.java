package com.tenbeggar.pob.repository;

import com.tenbeggar.pob.entity.GameModeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameModeRepository extends JpaRepository<GameModeEntity, String> {
}
