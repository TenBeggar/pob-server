package com.tenbeggar.pob.repository;

import com.tenbeggar.pob.entity.MatchTaskBillboardEntity;
import com.tenbeggar.pob.properties.Continent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchTaskBillboardRepository extends JpaRepository<MatchTaskBillboardEntity, String> {

    MatchTaskBillboardEntity findByContinentAndPuuid(Continent continent, String puuid);
}
