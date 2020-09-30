//package com.shanezhou.springboot.controller;
//
//import com.shanezhou.springboot.util.RedisStringUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//
///**
// * @Author ZhouWX
// * @CreateDate 2020/8/7 星期五
// */
//@RestController
//public class TestRedisController {
//
//    @Autowired
//    private RedisStringUtil redisStringUtil;
//
//    @Resource
//    private RedisTemplate redisTemplate;
//
//    @GetMapping("/redis")
//    public String testRedis() {
//        redisStringUtil.setKey("k1", "hello");
//        return "success";
//    }
//
//    @GetMapping("/redis1")
//    public String testRedis1() {
//        redisTemplate.opsForValue().set("k2", 11);
//        return "success";
//    }
//
//}
