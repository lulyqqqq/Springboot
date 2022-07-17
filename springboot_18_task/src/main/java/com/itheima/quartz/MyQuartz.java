package com.itheima.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @ClassName: MyQuartz
 * @author: mafangnian
 * @date: 2022/7/14 15:13
 * @Blog: null
 */
public class MyQuartz extends QuartzJobBean {
    // 具体要做的事
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        System.out.println("Quartz is running....");
    }
}
