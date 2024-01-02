package com.tenbeggar.pob.config;

import com.tenbeggar.pob.utils.SnowFlake;
import jakarta.annotation.Resource;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.stereotype.Component;

@Component
public class SnowFlakeIdGenerator implements IdentifierGenerator {

    @Resource
    private SnowFlake snowFlake;

    @Override
    public Object generate(SharedSessionContractImplementor session, Object object) {
        return String.valueOf(snowFlake.nextId());
    }
}
