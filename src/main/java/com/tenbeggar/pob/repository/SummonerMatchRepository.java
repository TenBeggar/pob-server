package com.tenbeggar.pob.repository;

import com.tenbeggar.pob.entity.SummonerMatchEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SummonerMatchRepository extends JpaRepository<SummonerMatchEntity, String> {

    Page<SummonerMatchEntity> findAllByPuuid(String puuid, Pageable pageable);
}
