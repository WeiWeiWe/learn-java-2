package com.practice.thread.mall;

// 模擬電商銷售商品
public class Mall {
    public synchronized void sale() {
        if (Stock.count > 0) {
            try {
                // 模擬電商處理銷售業務，用時5毫秒
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 銷售成功，庫存減少
            Stock.count--;
            System.out.println("商品銷售成功");
        } else {
            System.out.println("商品庫存不足，請下次再來吧！");
        }
    }

    public static void main(String[] args) {
        // 實例化唯一的電商對象
        Mall mall = new Mall();

        // 模擬5名消費者同時湧入電商網站購買商品
        for (int i = 0; i < 5; i++) {
            Consumer consumer = new Consumer();
            consumer.mall = mall;
            Thread thread = new Thread(consumer);
            thread.start();
        }

        try {
            // 模擬下班後，判斷庫存
            Thread.sleep(1000);
            System.out.println("當前商品庫存為：" + Stock.count);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
