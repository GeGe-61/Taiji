package com.redis.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisCluster;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

@RestController
public class LoginController {

    @Autowired
    private StringRedisTemplate template;

    private String LOGIN_COUNT="login_count";
    private String LOGIN_LOCK="login_lock";

    @GetMapping("/login")
    public String userLogin(String username,String password){

        if("1".equals(username)&&"1".equals(password)){
            return "success";
        }else{

            increaseFailLoginCount(username);

            if("1".equals(template.opsForValue().get(LOGIN_LOCK+username))){
                return "锁了";
            }else{
                return "error";
            }
        }

    }


    private void increaseFailLoginCount(String username){

           //count++
           template.opsForValue().increment(LOGIN_COUNT+username,1);
         //value<3，LOGIN_LOCK设为“”“”“”“0不锁
         if(Long.parseLong(template.opsForValue().get(LOGIN_COUNT+username))<3){
             template.opsForValue().set(LOGIN_LOCK+username,"0");
         //value>=3,LOGIN_LOCK设为1锁
         }else{
             template.opsForValue().set(LOGIN_LOCK+username,"1");

         }
         //设置LOGIN_COUNT()
        template.expire(LOGIN_COUNT+username,5,TimeUnit.MINUTES);
         //设置LOGIN_LOCK的过期时间
        template.expire(LOGIN_LOCK+username,5,TimeUnit.MINUTES);


    }


}

