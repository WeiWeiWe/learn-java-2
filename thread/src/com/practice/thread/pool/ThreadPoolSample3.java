package com.practice.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolSample3 {
    public static void main(String[] args) {
        /**
         * 創建一個單線程線程池(newSingleThreadExecutor)：
         */
        ExecutorService threadPool = Executors.newSingleThreadExecutor();

        for (int i = 1; i <= 1000; i++) {
            final int index = i;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + ":" + index);
                }
            });
        }

        threadPool.shutdown();
    }
}
