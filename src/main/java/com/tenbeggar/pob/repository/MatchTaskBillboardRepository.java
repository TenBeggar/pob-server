package com.tenbeggar.pob.repository;

import com.tenbeggar.pob.entity.MatchTaskBillboardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchTaskBillboardRepository extends JpaRepository<MatchTaskBillboardEntity, String> {

    MatchTaskBillboardEntity findByContinentAndPuuid(String continent, String puuid);
}
