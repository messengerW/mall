package com.mall.product.feign;
/*
 * File: SeckillFeignService.java
 * Date: 2021-01-31 17:51
 * Author: msw
 * PS ...
 */


import com.mall.common.utils.R;
import com.mall.product.feign.fallback.SecKillFeignServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "mall-seckill",fallback = SecKillFeignServiceFallback.class)
public interface SeckillFeignService {

    @GetMapping("/sku/seckill/{skuId}")
    R getSkuSeckillInfo(@PathVariable("skuId") Long skuId);
}