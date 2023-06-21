package com.practice.thread;

import com.sun.corba.se.impl.orbutil.concurrent.Sync;

public class SyncSample {

    class Printer {
        // 鎖對象
        Object lock = new Object();

        // 1. synchronized 代碼塊
        public void print1() {
            synchronized (lock) {
                try {
                    Thread.sleep(500);
                    System.out.print("魑");
                    Thread.sleep(500);
                    System.out.print("魅");
                    Thread.sleep(500);
                    System.out.print("魍");
                    Thread.sleep(500);
                    System.out.print("魎");
                    System.out.println();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        // 2. synchronized 方法 -> 對 this 對象加鎖 -> 實際使用較多
        public synchronized void print2() {
            try {
                Thread.sleep(500);
                System.out.print("魑");
                Thread.sleep(500);
                System.out.print("魅");
                Thread.sleep(500);
                System.out.print("魍");
                Thread.sleep(500);
                System.out.print("魎");
                System.out.println();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // 3. synchronized 靜態方法 -> 對當前類的字節碼對象加鎖 -> 實際使用較少，稍微了解下即可
    }

    class PrintTask implements Runnable {
        public Printer printer;

        @Override
        public void run() {
            printer.print2();
        }
    }
    public void start() {
        Printer printer = new Printer();
        for (int i = 0; i < 10; i++) {
            PrintTask task = new PrintTask();
            task.printer = printer; // 這邊都要用同一個實例，才能保證是同一個鎖，才可確保是同步執行的！
            Thread thread = new Thread(task);
            thread.start();
        }
    }

    public static void main(String[] args) {
        SyncSample sample = new SyncSample();
        sample.start();
    }
}
