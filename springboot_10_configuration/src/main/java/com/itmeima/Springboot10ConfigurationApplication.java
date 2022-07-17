package com.itmeima;

import com.alibaba.druid.pool.DruidDataSource;
import com.itmeima.config.ServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@EnableConfigurationProperties(ServerConfig.class)
public class Springboot10ConfigurationApplication {

    @Bean
    @ConfigurationProperties(prefix = "datasource")
    public DruidDataSource druidDataSource(){
        DruidDataSource ds = new DruidDataSource();
        return ds;
    }
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Springboot10ConfigurationApplication.class,args);
        ServerConfig bean = ctx.getBean(ServerConfig.class);
//        SpringApplication.run(Springboot10ConfigurationApplication.class, args);
        System.out.println(bean);
        DruidDataSource ds = ctx.getBean(DruidDataSource.class);
        System.out.println(ds.getDriverClassName());
    }

}
