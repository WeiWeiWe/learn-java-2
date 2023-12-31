package com.practice.collection.map;

import java.util.*;

public class LoopSample {
    public void doForLoop(Map map) {
        Set<String> keys = map.keySet();
        for (String k : keys) {
            System.out.println(k + ":" + map.get(k));
        }
    }

    public void doForEach(Map map) {
        map.forEach((key, value) -> {
            System.out.println(key + ":" + value);
        });
    }

    public void doIterator(Map map) {
        Iterator<Map.Entry<String, Object>> itr = map.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<String, Object> entry = itr.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Map<String, Object> student = new LinkedHashMap<>();
        student.put("name", "小明");
        student.put("age", 18);
        student.put("height", 180);
        student.put("weight", 60);
        System.out.println(student);

        LoopSample loopSample = new LoopSample();
        loopSample.doForLoop(student);
        loopSample.doForEach(student);
        loopSample.doIterator(student);
    }
}
