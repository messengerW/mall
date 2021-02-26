package com.mall.order;

import com.alibaba.cloud.seata.GlobalTransactionAutoConfiguration;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * RabbitMQ
 * 1.引入amqp场景，RabbitAutoConfiguration就会自动生效
 * 2.给容器中自动配置 RabbitTemplate、CachingConnectionFactory、RabbitMessagingTemplate
 * 3.前往 application.properties 中配置
 * 4.@EnableRabbit
 * 5.监听消息: 使用 @RabbitListener
 *
 * */

//@EnableAspectJAutoProxy(exposeProxy = true)
@EnableRedisHttpSession
@EnableFeignClients
@EnableDiscoveryClient
@EnableRabbit
@SpringBootApplication(exclude = GlobalTransactionAutoConfiguration.class)
public class MallOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MallOrderApplication.class, args);
	}

}
