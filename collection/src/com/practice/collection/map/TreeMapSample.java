package com.practice.collection.map;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapSample {
    class RecordComparator implements Comparator<String>{
        @Override
        public int compare(String o1, String o2) {
            return o2.compareTo(o1);
        }
    }

    public void sort() {
        // TreeMap 是有序的，會自動升序排列，此外，要改成降序排列，可以透過第一個參數改變排序方式
        TreeMap<String, Object> record = new TreeMap<>(new RecordComparator());
        record.put("A1", "1");
        record.put("C3", "2");
        record.put("B5", "3");
        record.put("X1", "4");
        record.put("C1", "5");
        record.put("B1", "6");
        System.out.println(record);
    }

    public static void main(String[] args) {
        TreeMapSample sample = new TreeMapSample();
        sample.sort();
    }
}
