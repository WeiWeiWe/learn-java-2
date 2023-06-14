package com.practice.collection.set;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetSample {
    public static void main(String[] args) {
        Set<String> mobileSet = new LinkedHashSet<>();
        //
        /**
         * LinkedHashSet 是根據 add 的順序來決定排列順序的，
         * 但底層依然是透過 hash 計算的，只是比 HashSet 多了 Linked 增加指針，
         * 讓集合是有順序的！
         */
        mobileSet.add("Iphone5");
        mobileSet.add("Iphone1");
        mobileSet.add("Iphone2");
        mobileSet.add("Iphone3");
        mobileSet.add("Iphone4");
        System.out.println(mobileSet);
    }
}
