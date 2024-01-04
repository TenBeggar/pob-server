package com.tenbeggar.pob.repository;

import com.tenbeggar.pob.entity.ChampionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChampionRepository extends JpaRepository<ChampionEntity, String> {

    ChampionEntity findByIdAndVersionAndLanguage(Integer id, String version, String language);

    List<ChampionEntity> findAllByVersionAndLanguage(String version, String language);
}
