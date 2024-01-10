package com.tenbeggar.pob.repository;

import com.tenbeggar.pob.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<ItemEntity, String> {

    List<ItemEntity> findAllByVersionAndLanguage(String version, String language);
}
