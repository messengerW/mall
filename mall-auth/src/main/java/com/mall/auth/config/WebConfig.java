package com.mall.auth.config;
/*
 * File: WebConfig.java
 * Date: 2021-02-05 15:57
 * Author: msw
 * PS ...
 */


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * 视图映射（替代 Controller 中的空方法）
     *
     *     @GetMapping("/login.html")
     *     public String loginPage() {
     *         return "login";
     *     }
    */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        // 登陆页面
        registry.addViewController("/login.html").setViewName("login");

        // 注册页面
        registry.addViewController("/register.html").setViewName("register");

    }
}
