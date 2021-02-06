package com.mall.auth.vo;
/*
 * File: UserLoginVo.java
 * Date: 2021-02-06 15:18
 * Author: msw
 * PS ...
 */


import lombok.Data;

@Data
public class UserLoginVo {

    private String loginacct;

    private String password;
}