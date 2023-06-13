package com.practice.collections;

import java.util.HashSet;

public class UniqueSetSample {
    public static void main(String[] args) {
        /**
         * Set 集合如何確保數據的唯一性：
         *  1. Set 集合在新增數據時，先判斷數據的 hashCode() 是否已存在
         *  2. 如果 hashCode() 在 Set 集合存在時，再調用 equals() 進行值的比較
         *  3. 所以 hashCode() 與 equals() 都存在的情況下，Set 集合才認為數據已存在，不能再次新增
         */
        String a = "a";
        String b = "b";
        System.out.println(a.hashCode() + ":" + b.hashCode());

        /**
         * 因為 Object 類本身就有 hashCode 方法，然後每次 new 出來的新對象一定都會是不同的地址，
         * 所以會導致下方 sn 如果都相同的情況，一樣都會加入到集合中，要解決這個情況的話，
         * 就要到 Goods 類中，去重寫 hashCode 和 equals 方法，改用 sn 的 hashCode！
         *
         * 為什麼除了用 hashCode 方法以外，還要用 equals 方法？
         *  1. 出於執行效率考慮
         *  2. hashCode 返回的整數結果決定了 Set 集合中存在的位置，且 hashCode 計算速度很快，但可能會出現 hash 碰撞！
         *  3. 所以針對 hash 碰撞的情況，還需要透過 equals 進行值的比較，雖然處理速度相對較慢
         *  4. 所以 hashCode 和 equals 方法一定是要同時存在，才可以確保數據再集合中是唯一的值！
         */
        HashSet<Goods> goodsSet = new HashSet<>();
        goodsSet.add(new Goods("11111", "IPHONE"));
        goodsSet.add(new Goods("11111", "IPHONE"));
        goodsSet.add(new Goods("22222", "TESTTEST"));
        goodsSet.add(new Goods("33333", "IPHONE"));
        System.out.println(goodsSet);
    }
}
