package com.tenbeggar.pob.config;

import com.tenbeggar.pob.utils.SnowFlake;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SnowFlakeConfig {

    @Value("${snowflake.datacenter-id}")
    private long datacenterId;
    @Value("${snowflake.machine-id}")
    private long machineId;

    @Bean
    public SnowFlake snowFlake() {
        return new SnowFlake(datacenterId, machineId);
    }
}
