package com.cloud.controller;

import com.cloud.common.CommonResult;
import com.cloud.entity.Authorization;
import com.cloud.entity.User;
import com.cloud.services.UserService;
import com.netflix.ribbon.proxy.annotation.Http;
import org.apache.ibatis.annotations.Delete;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.server.reactive.ServerHttpRequest;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@RestController
public class UserController {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private UserService userService;

    @PostMapping("/login")
    public CommonResult login(@RequestBody User user){
        Boolean exit = userService.user(user);
        if (exit) {
            String randomString = user.getUserName().concat("-token-").concat(getRandomString(10));
            // token存入redis
            stringRedisTemplate.opsForValue().set(randomString, "",30, TimeUnit.SECONDS);
            Authorization authorization = new Authorization(randomString);
            return new CommonResult(HttpStatus.OK.value(), "登录成功", authorization);
        } else {
            return new CommonResult(HttpStatus.BAD_REQUEST.value(), "用户不存在");
        }
    }

    @DeleteMapping("/logout")
    public CommonResult logout(ServerHttpRequest serverHttpRequest) {
        String authorization = serverHttpRequest.getHeaders().get("authorization").get(0).replace("Bearer ","");
        // 删除token
        stringRedisTemplate.delete(authorization);
        return new CommonResult(HttpStatus.OK.value(), "退出登录");
    }



    //length用户要求产生字符串的长度
    public String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
