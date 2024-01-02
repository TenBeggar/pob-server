package com.tenbeggar.pob.repository;

import com.tenbeggar.pob.entity.SummonerEntity;
import com.tenbeggar.pob.properties.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SummonerRepository extends JpaRepository<SummonerEntity, String> {

    SummonerEntity findByRegionAndName(Region region, String name);
}
