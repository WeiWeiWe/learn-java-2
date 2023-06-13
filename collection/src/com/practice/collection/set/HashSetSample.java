package com.practice.collection.set;

import java.util.HashSet;
import java.util.Set;

public class HashSetSample {
    public static void main(String[] args) {
        Set<String> mobileSet = new HashSet<>();

        // set 是無序的，不一定會按照加入的順序進行排序
        mobileSet.add("13311112222"); // 3
        mobileSet.add("13333334444"); // 1
        mobileSet.add("13355556666"); // 2
        System.out.println(mobileSet);

        // set 是不允許有重複的值
        boolean isChanged = mobileSet.add("13377778888");
        System.out.println("Set集合是否發生變化：" + isChanged);
        isChanged = mobileSet.add("13377778888");
        System.out.println("Set集合是否發生變化：" + isChanged);
        System.out.println(mobileSet);

        // size() : int
        int count = mobileSet.size();
        System.out.println("目前的集合數量：" + count);

        // contains(Object o) : boolean
        boolean result = mobileSet.contains("13377778888");
        System.out.println("集合是否有此數值：" + result);
    }
}

