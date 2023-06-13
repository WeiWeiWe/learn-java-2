package com.practice.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListLoopSample {
    public static void main(String[] args) {
        // ArrayList 可以簡化使用 List 接口即可
        List<String> bookList = new ArrayList<>();
        bookList.add("三國演義");
        bookList.add("水滸傳");
        bookList.add("西游記");
        bookList.add("紅樓夢");

        // for
        for (String book : bookList) {
            System.out.println(book);
        }

        // forEach
        bookList.forEach(book -> {
            System.out.println(book);
        });

        // iterator
        Iterator<String> itr = bookList.iterator();
        while (itr.hasNext()) {
            String book = itr.next(); // 提取出下一個元素，同時將指針向後移動
            System.out.println(book);
        }
    }
}
