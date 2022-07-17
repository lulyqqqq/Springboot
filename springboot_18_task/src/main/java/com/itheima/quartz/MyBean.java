package com.itheima.quartz;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @ClassName: MyBean
 * @author: mafangnian
 * @date: 2022/7/14 15:34
 * @Blog: null
 */
@Configuration
public class MyBean {

    //设置执行时间
    @Scheduled(cron = "0/3 * * * * ?")
    public void print(){
        System.out.println(Thread.currentThread().getName() + "spring task is running.....");
    }
}
