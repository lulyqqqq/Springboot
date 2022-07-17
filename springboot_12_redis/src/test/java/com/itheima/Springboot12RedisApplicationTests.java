package com.itheima;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class Springboot12RedisApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;

    @Test
    void sets(@Autowired StringRedisTemplate stringRedisTemplate){
        ValueOperations ops = stringRedisTemplate.opsForValue();
        ops.set("testKey","TestValue");
    }

    @Test
    void gets(@Autowired StringRedisTemplate stringRedisTemplate){
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        String testKey = ops.get("testKey");
        System.out.println(testKey);
    }


    @Test
    void set() {
        ValueOperations ops = redisTemplate.opsForValue();
        HashOperations oph = redisTemplate.opsForHash();
        ops.set("age",41);
        oph.put("info","a","aa");
    }


    @Test
    void get(){
        ValueOperations ops = redisTemplate.opsForValue();
        HashOperations oph = redisTemplate.opsForHash();
        oph.get("info","a");
        Object age = ops.get("age");
        System.out.println(age);
        System.out.println(oph);
    }

}
