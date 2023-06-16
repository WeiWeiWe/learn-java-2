package com.practice.collection.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListSorter {

    class SampleComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            /**
             * 結果 > 0，則交換位置
             * 結果 = 0 或 < 0，則位置不變
             */
            return o2 - o1;
        }
    }

    public List<Integer> sort(List<Integer> list) {
        Collections.sort(list, new SampleComparator());
        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(70);
        list.add(90);
        list.add(30);
        list.add(50);
        System.out.println(list);

        ListSorter listSorter = new ListSorter();
        List<Integer> list1 = listSorter.sort(list);
        System.out.println(list1);
        System.out.println(list); // 原陣列也會跟著改動！
    }
}
