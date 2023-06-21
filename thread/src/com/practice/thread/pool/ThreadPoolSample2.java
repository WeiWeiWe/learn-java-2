package com.practice.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolSample2 {
    public static void main(String[] args) {
        /**
         * 創建一個可緩存線程池(newCachedThreadPool)：
         *  可緩存線程池的特點是無限大，
         *  如果線程池中沒有可用的線程，
         *  則創建新的，有空閒的線程，則直接利用起來！
         */
        ExecutorService threadPool = Executors.newCachedThreadPool();

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
