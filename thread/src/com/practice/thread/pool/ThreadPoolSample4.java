package com.practice.thread.pool;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolSample4 {
    public static void main(String[] args) {
        // 調度線程池 (newScheduledThreadPool)
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);

        // 延遲1秒執行，每3秒執行一次
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(new Date() + "延遲1秒執行，每3秒執行一次");
            }
        }, 1, 3, TimeUnit.SECONDS);
    }
}
