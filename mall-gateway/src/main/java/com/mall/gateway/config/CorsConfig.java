package com.mall.gateway.config;
/*
 * File: CorsConfig.java
 * Date: 2020-07-26 21:31
 * Author: msw
 * PS ...
 */


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@Configuration
public class CorsConfig {

    @Bean
    public CorsWebFilter corsWebFilter() {

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();

        // 配置跨域
        corsConfiguration.addAllowedHeader("*");    // 头
        corsConfiguration.addAllowedMethod("*");    // 方式
        corsConfiguration.addAllowedOrigin("*");    // 来源
        corsConfiguration.setAllowCredentials(true);    // 是否允许cookie

        source.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsWebFilter(source);
    }
}
