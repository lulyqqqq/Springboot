package com.itheima;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//jetcache启用缓存的主开关
@EnableCreateCacheAnnotation
//开启方法注解缓存 在方法头上设置开启缓存 指定扫描的包
@EnableMethodCache(basePackages = "ithima")
public class Springboot16JetcacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot16JetcacheApplication.class, args);
    }

}
