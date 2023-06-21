package com.practice.thread.mall;

// 消費者類
public class Consumer implements Runnable {
    // 所有消費者都來到同一個電商網站
    public Mall mall;

    @Override
    public void run() {
        // 電商為每一名消費者銷售商品
        mall.sale();
    }
}
