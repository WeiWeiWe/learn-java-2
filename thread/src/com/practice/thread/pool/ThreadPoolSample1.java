package com.practice.thread.pool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolSample1 {
    public static void main(String[] args) {
        /**
         * 創建一個定長線程池(newFixedThreadPool)：
         *  定長線程池的特點是固定線程總數，
         *  空閒線程用於執行任務，如果線程都在使用，
         *  後續任務則處於等待狀態
         */
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        for (int i = 1; i <= 1000; i++) {
            final int index = i;
            // 不需要返回值，使用 execute 方法執行 Runnable 對象
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + ":" + index);
                }
            });

            // 需要返回值，使用 submit 方法執行 Callable 對象，利用 Future 對象接收返回值
//            Future<Object> ret = threadPool.submit(new Callable<Object>() {
//               @Override
//               public Object call() throws Exception {
//                   return null;
//               }
//            });
        }

        threadPool.shutdown();
    }
}
