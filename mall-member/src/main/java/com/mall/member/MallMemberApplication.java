package com.mall.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * 远程调用别的服务
 * 1.引入 open-feign
 * 2.编写一个接口，告诉SpringCloud这个接口需要调用远程服务，声明接口的每一个方法分别是调用哪一个远程服务的哪一个请求
 * 3.开启远程调用功能
 */

@EnableRedisHttpSession
@EnableFeignClients(basePackages = "com.mall.member.feign")
@EnableDiscoveryClient
@SpringBootApplication
public class MallMemberApplication {

	public static void main(String[] args) {
		SpringApplication.run(MallMemberApplication.class, args);
	}

}
