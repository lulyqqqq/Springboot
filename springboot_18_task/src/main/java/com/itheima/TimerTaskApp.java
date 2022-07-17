package com.itheima;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @ClassName: TimerTaskApp
 * @author: mafangnian
 * @date: 2022/7/14 14:09
 * @Blog: null
 */
public class TimerTaskApp {

    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Timer is running....");
            }
        };
        timer.schedule(task,0,2000);
    }
}
