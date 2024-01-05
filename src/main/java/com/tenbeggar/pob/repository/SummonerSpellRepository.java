package com.tenbeggar.pob.repository;

import com.tenbeggar.pob.entity.SummonerSpellEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SummonerSpellRepository extends JpaRepository<SummonerSpellEntity, String> {

    SummonerSpellEntity findByIdAndVersionAndLanguage(Integer id, String version, String language);
}
