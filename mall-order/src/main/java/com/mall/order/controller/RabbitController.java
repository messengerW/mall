package com.mall.order.controller;
/*
 * File: RabbitController.java
 * Date: 2021-02-18 20:27
 * Author: msw
 * PS ...
 */

import com.mall.order.entity.OrderEntity;
import com.mall.order.entity.OrderItemEntity;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
public class RabbitController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/sendMQ")
    public String sendMQ(@RequestParam(value = "num", required = false, defaultValue = "10") Integer num){

        OrderEntity entity = new OrderEntity();
        entity.setId(1L);
        entity.setCommentTime(new Date());
        entity.setCreateTime(new Date());
        entity.setConfirmStatus(0);
        entity.setAutoConfirmDay(1);
        entity.setGrowth(1);
        entity.setMemberId(12L);

        OrderItemEntity orderEntity = new OrderItemEntity();
        orderEntity.setCategoryId(225L);
        orderEntity.setId(1L);
        orderEntity.setOrderSn("mall");
        orderEntity.setSpuName("华为");
        for (int i = 0; i < num; i++) {
            if(i % 2 == 0){
                entity.setReceiverName("FIRE-" + i);
                rabbitTemplate.convertAndSend("hello-java-exchange", "hello.java", entity, new CorrelationData(UUID.randomUUID().toString().replace("-","")));
            }else {
                orderEntity.setOrderSn("mall-" + i);
                rabbitTemplate.convertAndSend("hello-java-exchange", "hello.java", orderEntity, new CorrelationData(UUID.randomUUID().toString().replace("-","")));
                // 测试消息发送失败
//				rabbitTemplate.convertAndSend(this.exchange, this.routeKey + "test", orderEntity);
            }
        }
        return "ok";
    }
}