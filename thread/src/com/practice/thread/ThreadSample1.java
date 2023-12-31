package com.practice.thread;

import java.util.Random;

public class ThreadSample1 {
    class Runner extends Thread {
        @Override
        public void run() {
            Integer speed = new Random().nextInt(10);

            for (int i = 0; i <= 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("第" + i + "秒: " + this.getName() +
                        "已跑到" + (i * speed) + "米(" + speed + "米/秒)");
            }
        }
    }

    public void start() {
        Runner threadA = new Runner();
        threadA.setName("參賽者A");
        Runner threadB = new Runner();
        threadB.setName("參賽者B");
        Runner threadC = new Runner();
        threadC.setName("參賽者C");

        threadA.start();
        threadB.start();
        threadC.start();
    }

    public static void main(String[] args) {
//        System.out.println("參賽者A 10秒跑了100米");
//        System.out.println("參賽者B 10秒跑了60米");
//        System.out.println("參賽者C 10秒跑了80米");
        new ThreadSample1().start();
    }
}
