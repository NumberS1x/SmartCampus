package com.example.lyx.config;

import cn.hutool.jwt.JWT;

import java.util.Date;

public class LoginConfig {
    public static String addToken(Integer userid,String phone){
        //过期时间
        Date date = new Date(System.currentTimeMillis() + 72*60 * 60 * 1000);
        String token = JWT.create()
                .setPayload("userid", userid)
                .setKey(phone.getBytes())
                .setExpiresAt(date)
                .sign();
        return token;
    }

    public static String verifyToken(String token){
        JWT jwt = JWT.of(token);
        if (jwt.getPayloads().getLong("exp") <System.currentTimeMillis()){
            return null;
        }
        return jwt.getPayloads().getStr("userid");
    }
}
