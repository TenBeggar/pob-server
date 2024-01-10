package com.tenbeggar.pob.repository;

import com.tenbeggar.pob.entity.PerkEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PerkRepository extends JpaRepository<PerkEntity, String> {

    List<PerkEntity> findAllByVersionAndLanguage(String version, String language);
}
