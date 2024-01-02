package com.tenbeggar.pob.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.time.Duration;
import java.util.Collections;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOriginPatterns(Collections.singletonList("*"));//允许的域
        config.setAllowCredentials(true);//允许凭证
        config.addAllowedHeader(CorsConfiguration.ALL);//允许的请求头
        config.addAllowedMethod(CorsConfiguration.ALL);//允许的请求方式
        config.setMaxAge(Duration.ofHours(3));//有效时间
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
