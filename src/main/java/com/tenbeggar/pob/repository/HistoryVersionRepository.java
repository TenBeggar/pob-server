package com.tenbeggar.pob.repository;

import com.tenbeggar.pob.entity.HistoryVersionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryVersionRepository extends JpaRepository<HistoryVersionEntity, String> {

    HistoryVersionEntity findAllByVersionAndLanguage(String version, String language);
}
