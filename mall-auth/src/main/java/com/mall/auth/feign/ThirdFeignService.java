package com.mall.auth.feign;

/*
 * File: ThirdFeignService.java
 * Date: 2021-02-06 12:48
 * Author: msw
 * PS ...
 */

import com.mall.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("mall-third")
public interface ThirdFeignService {

    @GetMapping("/sms/sendcode")
    R sendCode(@RequestParam("phone") String phone, @RequestParam("code") String code);

}
