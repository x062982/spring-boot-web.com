//package com.shanezhou.springboot.util;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
//import org.springframework.stereotype.Component;
//
///**
// * @Author ZhouWX
// * @CreateDate 2020/8/7 星期五
// */
//@Component
//public class RedisStringUtil {
//
//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;
//
//    public void setKey(String key, String value) {
//        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
//        ops.set(key,value);
//    }
//
//    public String getKey(String key) {
//        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
//        return ops.get(key);
//    }
//}
