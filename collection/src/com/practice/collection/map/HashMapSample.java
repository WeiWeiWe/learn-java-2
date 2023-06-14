package com.practice.collection.map;

import java.util.HashMap;

public class HashMapSample {
    public static void main(String[] args) {
        HashMap<String, Object> student = new HashMap<>();

        // put(String key, Object value) : Object
        student.put("name", "小明");
        String name = (String)student.put("name", "小李");
        System.out.println(name + "已被替換為小李");
        student.put("age", 18);
        student.put("height", 180);
        student.put("weight", 60);
        System.out.println(student);

        // get(Object key) : Object
        String n = (String)student.get("name");
        System.out.println(n);

        // containsKey(Object key) : boolean
        boolean r1 = student.containsKey("name");
        boolean r2 = student.containsKey("name1");
        System.out.println(r1); // true
        System.out.println(r2); // false

        // containsValue(Object value) : boolean
        boolean r3 = student.containsValue(60);
        boolean r4 = student.containsValue(61);
        System.out.println(r3); // true
        System.out.println(r4); // false

        // size() : int
        int count = student.size();
        System.out.println(count);

        // remove(Object key) : Object
        Integer w = (Integer)student.remove("weight");
        System.out.println("weight項已被移除，其值為：" + w);
        System.out.println(student);
    }
}
