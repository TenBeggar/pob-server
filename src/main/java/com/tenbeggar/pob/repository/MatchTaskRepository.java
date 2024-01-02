package com.tenbeggar.pob.repository;

import com.tenbeggar.pob.entity.MatchTaskEntity;
import com.tenbeggar.pob.properties.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchTaskRepository extends JpaRepository<MatchTaskEntity, String> {

    MatchTaskEntity findFirstByStatus(TaskStatus status);
}
