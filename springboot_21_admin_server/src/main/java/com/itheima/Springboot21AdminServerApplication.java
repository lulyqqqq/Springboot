package com.itheima;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//开启监控服务
@EnableAdminServer
public class Springboot21AdminServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot21AdminServerApplication.class, args);
    }

}
