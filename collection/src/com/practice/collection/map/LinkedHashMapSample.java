package com.practice.collection.map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapSample  {
    public static void main(String[] args) {
        Map<String, Object> student = new LinkedHashMap();
        student.put("name", "小明");
        student.put("age", 18);
        student.put("height", 180);
        student.put("weight", 60);
        System.out.println(student);
    }
}
