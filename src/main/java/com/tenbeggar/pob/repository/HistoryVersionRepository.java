package com.tenbeggar.pob.repository;

import com.tenbeggar.pob.entity.HistoryVersionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryVersionRepository extends JpaRepository<HistoryVersionEntity, String> {

    List<HistoryVersionEntity> findAllByVersion(String version);
}
