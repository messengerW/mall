package com.mall.ware.feign;

import com.mall.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/*
 * File: OrderFeignService.java
 * Date: 2021-02-26 18:26
 * Author: msw
 * PS ...
 */

@FeignClient("mall-order")
public interface OrderFeignService {

    /**
     * 查询订单状态
     */
    @GetMapping("/order/order/status/{orderSn}")
    R getOrderStatus(@PathVariable("orderSn") String orderSn);
}