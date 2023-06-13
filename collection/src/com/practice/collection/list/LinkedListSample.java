package com.practice.collection.list;

import java.util.LinkedList;

public class LinkedListSample {
    public static void main(String[] args) {
        LinkedList<String> bookList = new LinkedList<>();

        // add(String e)
        bookList.add("三國演義");
        bookList.add("西游記");
        bookList.add("紅樓夢");
        System.out.println("目前的書籍有：" + bookList);

        // add (int index, String element
        bookList.add(0, "水滸傳");
        System.out.println("目前的書籍有：" + bookList);

        // addFirst(String e)
        bookList.addFirst("首部添加");
        System.out.println("目前的書籍有：" + bookList);

        // addLast(String e)
        bookList.addLast("尾部添加");
        System.out.println("目前的書籍有：" + bookList);
    }
}
