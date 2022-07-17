package com.itheima.config;

import com.itheima.quartz.MyQuartz;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: QuartzConfig
 * @author: mafangnian
 * @date: 2022/7/14 15:17
 * @Blog: null
 */

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail printJobDetail(){
        //绑定具体工作
        return JobBuilder.newJob(MyQuartz.class).storeDurably().build();
    }

    @Bean
    public Trigger printTrigger(){
        //绑定具体的工作明显
        ScheduleBuilder<? extends Trigger> schedBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
        return TriggerBuilder.newTrigger().forJob(printJobDetail()).withSchedule(schedBuilder).build();
    }

}
