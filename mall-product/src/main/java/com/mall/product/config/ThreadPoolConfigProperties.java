package com.mall.product.config;
/*
 * File: ThreadPoolConfigProperties.java
 * Date: 2021-02-03 16:54
 * Author: msw
 * PS ...
 */

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "mall.thread")
@Component
@Data
public class ThreadPoolConfigProperties {

    private Integer coreSize;

    private Integer maxSize;

    private Integer keepAliveTime;

}
