package com.tenbeggar.pob.repository;

import com.tenbeggar.pob.entity.SummonerSpellEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SummonerSpellRepository extends JpaRepository<SummonerSpellEntity, String> {

    SummonerSpellEntity findByIdAndVersionAndLanguage(Integer id, String version, String language);

    List<SummonerSpellEntity> findAllByVersionAndLanguage(String version, String language);
}
