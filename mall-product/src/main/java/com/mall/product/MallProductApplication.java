package com.mall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 一、整合 MyBatis-plus
 * 1.导入依赖
 * <dependency>
 *       <groupId>com.baomidou</groupId>
 *       <artifactId>mybatis-plus-boot-starter</artifactId>
 *       <version>3.2.0</version>
 *</dependency>
 * 2.配置
 *   1）配置数据源
 *   	① 导入数据库驱动(mall-common的pom)
 *   	② 配置数据源(application.yml)
 *   2）配置 Mybatis-plus
 *   	① 使用 @MapperScan
 *   	② 告诉 MyBatis-plus sql映射文件的位置
 *
 * 二、使用 MyBatis-plus 逻辑删除
 *   1. 配置全局的逻辑删除规则（可省略）
 *   2. 配置逻辑删除的组件Bean（可省略）
 *   3. 在Entity添加逻辑删除注解 @TableLogic
 * */
@MapperScan("com.mall.product.dao")
@EnableDiscoveryClient
@SpringBootApplication
public class MallProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(MallProductApplication.class, args);
	}

}
