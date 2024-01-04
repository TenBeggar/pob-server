package com.tenbeggar.pob.repository;

import com.tenbeggar.pob.entity.ChampionSpellEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChampionSpellRepository extends JpaRepository<ChampionSpellEntity, String> {
}
