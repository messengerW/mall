package com.mall.order.web;
/*
 * File: HelloController.java
 * Date: 2021-02-19 16:22
 * Author: msw
 * PS ...
 */

import com.mall.order.entity.OrderEntity;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.UUID;

@Controller
public class HelloController {

//    @Autowired
//    private RabbitTemplate rabbitTemplate;

    /**
     * 用于测试各个页面是否能正常访问
     * http://order.echoone.cn/confirm.html
     * http://order.echoone.cn/detail.html
     * http://order.echoone.cn/list.html
     * http://order.echoone.cn/pay.html
     */
    @GetMapping("/{page}.html")
    public String listPage(@PathVariable("page") String page){
        return page;
    }

//    @ResponseBody
//    @GetMapping("/test/createOrder")
//    public String createOrderTest(){
//
//        OrderEntity orderEntity = new OrderEntity();
//        orderEntity.setOrderSn(UUID.randomUUID().toString().replace("-",""));
//        orderEntity.setModifyTime(new Date());
//        rabbitTemplate.convertAndSend("order-event-exchange", "order.create.order", orderEntity);
//        return "下单成功";
//    }
}