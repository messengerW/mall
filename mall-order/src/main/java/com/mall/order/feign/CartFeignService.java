package com.mall.order.feign;
/*
 * File: CartFeignService.java
 * Date: 2021-02-20 16:54
 * Author: msw
 * PS ...
 */

import com.mall.order.vo.OrderItemVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("mall-cart")
public interface CartFeignService {

    @GetMapping("/currentUserCartItems")
    List<OrderItemVo> getCurrentUserCartItems();

}