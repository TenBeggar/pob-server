package com.tenbeggar.pob.repository;

import com.tenbeggar.pob.entity.QueueEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QueueRepository extends JpaRepository<QueueEntity, String> {
}
