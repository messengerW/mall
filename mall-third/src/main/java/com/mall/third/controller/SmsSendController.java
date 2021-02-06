package com.mall.third.controller;
/*
 * File: SmsSendController.java
 * Date: 2021-02-05 18:29
 * Author: msw
 * PS ...
 */


import com.mall.common.utils.R;
import com.mall.third.component.SmsComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/sms")
public class SmsSendController {

    @Autowired
    private SmsComponent smsComponent;

    /**
     * 提供给别的服务进行调用的
     */
    @GetMapping("/sendcode")
    public R sendCode(@RequestParam("phone") String phone, @RequestParam("code") String code){

        smsComponent.sendSmsCode(phone, code);

        return R.ok();
    }
}