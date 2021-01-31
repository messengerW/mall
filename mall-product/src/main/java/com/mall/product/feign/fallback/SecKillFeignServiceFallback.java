package com.mall.product.feign.fallback;
/*
 * File: SecKillFeignServiceFalback.java
 * Date: 2021-01-31 17:52
 * Author: msw
 * PS ...
 */


import com.mall.common.exception.BusinessCodeEnum;
import com.mall.common.utils.R;
import com.mall.product.feign.SeckillFeignService;
import org.springframework.stereotype.Component;

@Component
public class SecKillFeignServiceFallback implements SeckillFeignService {

    @Override
    public R getSkuSeckillInfo(Long skuId) {
        System.out.println("触发熔断");
        return R.error(BusinessCodeEnum.TO_MANY_REQUEST.getCode(), BusinessCodeEnum.TO_MANY_REQUEST.getMsg());
    }
}
