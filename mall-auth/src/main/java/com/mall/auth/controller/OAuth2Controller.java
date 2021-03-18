package com.mall.auth.controller;
/*
 * File: OAuth2Controller.java
 * Date: 2021-03-18 19:11
 * Author: msw
 * PS ...
 */


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.mall.auth.feign.MemberFeignService;
import com.mall.auth.vo.SocialUser;
import com.mall.common.constant.AuthServerConstant;
import com.mall.common.utils.HttpUtils;
import com.mall.common.utils.R;
import com.mall.common.vo.MemberRsepVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/oauth2.0")
public class OAuth2Controller {

    @Autowired
    private MemberFeignService memberFeignService;

    /**
     * 登录成功回调
     * {
     * "access_token": "2.00Z6fewGmRSYrB6e9816eb020BaFqa",
     * "uid": "6363516789",
     * }
     */
    @GetMapping("/weibo/success")
    public String weibo(@RequestParam("code") String code, HttpSession session) throws Exception {

        // 根据code换取 Access Token
        Map<String, String> map = new HashMap<>();
        // https://open.weibo.com/apps/1707452086/info/basic 查看应用信息（app-key对应client-id）
        map.put("client_id", "1707452086");
        map.put("client_secret", "995c282da52e79691f6fd7a957fa210c");
        map.put("grant_type", "authorization_code");
        map.put("redirect_uri", "http://auth.echoone.cn/oauth2.0/weibo/success");
        map.put("code", code);
        Map<String, String> headers = new HashMap<>();
        HttpResponse response = HttpUtils.doPost("https://api.weibo.com", "/oauth2/access_token", "post", headers, null, map);
        if (response.getStatusLine().getStatusCode() == 200) {
            // 成功利用 code 获取到 Access Token
            String json = EntityUtils.toString(response.getEntity());
            SocialUser socialUser = JSON.parseObject(json, SocialUser.class);

            // 相当于我们知道了当前是那个用户
            // 1.如果用户是第一次进来 自动注册进来(为当前社交用户生成一个会员信息 以后这个账户就会关联这个账号)
            R login = memberFeignService.login(socialUser);
            if (login.getCode() == 0) {
                MemberRsepVo rsepVo = login.getData("data", new TypeReference<MemberRsepVo>() {
                });

                log.info("\n欢迎 [" + rsepVo.getUsername() + "] 使用社交账号登录");
                // 第一次使用session 命令浏览器保存这个用户信息 JESSIONSEID 每次只要访问这个网站就会带上这个cookie
                // 在发卡的时候扩大session作用域 (指定域名为父域名)
                // TODO 1.默认发的当前域的session (需要解决子域session共享问题)
                // TODO 2.使用JSON的方式序列化到redis
//				new Cookie("JSESSIONID","").setDomain("glmall.com");
                session.setAttribute(AuthServerConstant.LOGIN_USER, rsepVo);
                // 登录成功 跳回首页
                return "redirect:http://echoone.cn";
            } else {
                // 社交登录失败，跳转回登录页
                return "redirect:http://auth.echoone.cn/login.html";
            }
        } else {
            return "redirect:http://auth.echoone.cn/login.html";
        }
    }
}
