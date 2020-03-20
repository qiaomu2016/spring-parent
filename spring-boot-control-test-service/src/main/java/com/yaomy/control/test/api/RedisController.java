package com.yaomy.control.test.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring-parent
 * @description: Redis控制器
 * @author: 姚明洋
 * @create: 2020/03/19
 */
@RestController
public class RedisController {
    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/redis/test")
    public String testRedisson(){
        redisTemplate.opsForValue().set("test", "测试数据abc123");

        return "SUCCESS";
    }
}
