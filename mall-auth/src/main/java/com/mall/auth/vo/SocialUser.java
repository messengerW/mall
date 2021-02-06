package com.mall.auth.vo;
/*
 * File: SocialUser.java
 * Date: 2021-02-06 15:18
 * Author: msw
 * PS ...
 */


import lombok.Data;

@Data
public class SocialUser {

    private String accessToken;

    private String remindIn;

    private int expiresIn;

    private String uid;

    private String isrealname;
}