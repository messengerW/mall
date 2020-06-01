package com.mall.member.feign;

/*
 * File: CouponFeignService.java
 * Date: 2020-06-01 21:55
 * Author: msw
 * PS ...
 */

import com.mall.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

// 声明式的远程调用
@FeignClient("mall-coupon")
public interface CouponFeignService {

    @RequestMapping("/coupon/coupon/member/list")
    R memberCoupons();
}
