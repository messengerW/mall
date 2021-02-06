package com.mall.auth.feign;

/*
 * File: MemberFeignService.java
 * Date: 2021-02-06 15:20
 * Author: msw
 * PS ...
 */

import com.mall.auth.vo.SocialUser;
import com.mall.auth.vo.UserLoginVo;
import com.mall.auth.vo.UserRegisterVo;
import com.mall.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("mall-member")
public interface MemberFeignService {

    @PostMapping("/member/member/register")
    R register(@RequestBody UserRegisterVo userRegisterVo);

    @PostMapping("/member/member/login")
    R login(@RequestBody UserLoginVo vo);

    @PostMapping("/member/member/oauth2/login")
    R login(@RequestBody SocialUser socialUser);
}