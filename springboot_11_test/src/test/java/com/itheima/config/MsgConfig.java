package com.itheima.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: MsgConfig
 * @author: mafangnian
 * @date: 2022/7/8 15:09
 * @Blog: null
 */
@Configuration
public class MsgConfig {

    @Bean
    public String msg(){
        return "bean msg";
    }

}
