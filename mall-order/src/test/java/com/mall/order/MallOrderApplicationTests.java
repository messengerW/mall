package com.mall.order;

import com.mall.order.entity.OrderReturnReasonEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class MallOrderApplicationTests {

	@Autowired
	AmqpAdmin amqpAdmin;

	@Autowired
	RabbitTemplate rabbitTemplate;

	@Test
	public void createExchange() {
		/**
		 * DirectExchange(String name, boolean durable, boolean autoDelete, Map<String, Object> arguments)
		 */
		DirectExchange directExchange = new DirectExchange("hello-java-exchange", true, false);
		amqpAdmin.declareExchange(directExchange);
		log.info("Exchange[{}]创建成功", "hello-java-exchange");
	}

	@Test
	public void createQueue() {
		Queue queue = new Queue("hello-java-queue", true, false, false);
		amqpAdmin.declareQueue(queue);
		log.info("Queue[{}]创建成功", "hello-java-queue");
	}

	@Test
	public void createBinding() {
		/**
		 * String destination: 目的地
		 * DestinationType destinationType: 目的地类型
		 * String exchange: 交换机
		 * String routingKey: 路由键
		 * Map<String, Object> args: 自定义参数
		 */
		Binding binding = new Binding("hello-java-queue",
				Binding.DestinationType.QUEUE,
				"hello-java-exchange",
				"hello.java",
				null);

		amqpAdmin.declareBinding(binding);
		log.info("Binding[{}]创建成功", "hello-java-binding");
	}

	@Test
	public void sendMessage() {
		// 1.发送 String 类型消息
		String msg = "Hello, I am MSW !";

		// 2.发送对象（对象需实现序列化接口）
		OrderReturnReasonEntity reasonEntity = new OrderReturnReasonEntity();
		reasonEntity.setId(1L);
		reasonEntity.setCreateTime(new Date());
		reasonEntity.setName("hahah");

		rabbitTemplate.convertAndSend("hello-java-exchange", "hello.java", reasonEntity);
		log.info("Message send successfully-{}...", reasonEntity);
	}

	@Test
	public void contextLoads() {
	}

}
