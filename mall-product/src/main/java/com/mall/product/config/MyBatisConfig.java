package com.mall.product.config;
/*
 * File: MyBatisConfig.java
 * Date: 2020-11-20 13:29
 * Author: msw
 * PS ...
 */

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/*
 * 引入 MyBatis 分页插件
 */
@Configuration
@EnableTransactionManagement    // 开启事务注解
@MapperScan("com.mall.product.dao")     // 指定 mapper 路径
public class MyBatisConfig {
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();

        // 设置请求的页面大于最大页后的操作，true跳回首页，false继续请求（默认为false）
        paginationInterceptor.setOverflow(true);

        // 设置单页最大限制数量（默认为500条，-1表示不受限制）
        paginationInterceptor.setLimit(1000);

        return paginationInterceptor;
    }

}
