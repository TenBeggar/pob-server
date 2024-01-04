package com.tenbeggar.pob.repository;

import com.tenbeggar.pob.entity.SummonerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SummonerRepository extends JpaRepository<SummonerEntity, String> {

    SummonerEntity findByRegionAndName(String region, String name);
}
