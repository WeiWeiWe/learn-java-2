package com.practice.thread;

import com.sun.corba.se.impl.orbutil.concurrent.Sync;

public class SyncSample {

    class Printer {
        // 鎖對象
        Object lock = new Object();

        // 1. synchronized 代碼塊
        public void print() {
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
    }

    class PrintTask implements Runnable {
        public Printer printer;

        @Override
        public void run() {
            printer.print();
        }
    }
    public void start() {
        Printer printer = new Printer();
        for (int i = 0; i < 10; i++) {
            PrintTask task = new PrintTask();
            task.printer = printer;
            Thread thread = new Thread(task);
            thread.start();
        }
    }

    public static void main(String[] args) {
        SyncSample sample = new SyncSample();
        sample.start();
    }
}
