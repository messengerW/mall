package com.mall.order.web;
/*
 * File: PayWebController.java
 * Date: 2021-03-02 16:52
 * Author: msw
 * PS ...
 */

import com.alipay.api.AlipayApiException;
import com.mall.order.config.AlipayTemplate;
import com.mall.order.service.OrderService;
import com.mall.order.vo.PayVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PayWebController {

    @Autowired
    private AlipayTemplate alipayTemplate;

    @Autowired
    private OrderService orderService;

    /**
     * 告诉浏览器我们会返回一个html页面
     */
    @ResponseBody
    @GetMapping(value = "/payOrder", produces = "text/html")
    public String payOrder(@RequestParam("orderSn") String orderSn) throws AlipayApiException {

        PayVo payVo = orderService.getOrderPay(orderSn);
        return alipayTemplate.pay(payVo);
    }
}