package com.tenbeggar.pob.entity;

import com.tenbeggar.pob.config.SnowFlakeIdGenerator;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;

@Data
@MappedSuperclass
public class BaseEntity implements Serializable {

    @Id
    @GenericGenerator(name = "snowFlakeIdGenerator", type = SnowFlakeIdGenerator.class)
    @GeneratedValue(generator = "snowFlakeIdGenerator")
    private String pobId;
}
