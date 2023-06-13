package com.practice.collection.list;

import java.util.ArrayList;

public class ArrayListSample {
    public static void main(String[] args) {
        // ArrayList<>
        ArrayList<String> bookList = new ArrayList<String>();

        // add(String e)
        bookList.add("三國演義");
        bookList.add("水滸傳");
        System.out.println(bookList);

        // get
        String bookName1 = bookList.get(1);
        System.out.println(bookName1);

        // add(int index, string element)
        bookList.add(1, "紅樓夢");
        System.out.println(bookList);

        // add(String e) : boolean
        boolean result1 = bookList.add("西游記");
        System.out.println("列表是否發生變化：" + result1);

        // set(int index, string element) : string
        String before = bookList.set(3, "西游記後傳");
        System.out.println("被更改前的書名：" + before);
        System.out.println("更改書名後，目前的bookList：" + bookList);

        // remove(Object o) : boolean
        boolean result2 = bookList.remove("西游記後傳");
        System.out.println("有找到對應的書籍並直接刪除：" + result2);
        System.out.println("刪除書籍後，目前的bookList：" + bookList);

        // remove(int index) : string
        String item = bookList.remove(0);
        System.out.println("被刪除的書籍是：" + item);
        System.out.println("刪除書籍後，目前的bookList：" + bookList);

        // size() : int
        int count = bookList.size();
        System.out.println("目前書籍有 " + count + " 本");

        // 使用 size 方法，更新 bookList 的最後一本書籍
        bookList.set(bookList.size() - 1, "測試測試");
        System.out.println("更改書名後，目前的bookList：" + bookList);

        // 使用 size 方法，刪除 bookList 的最後一本書籍
        bookList.remove(bookList.size() - 1);
        System.out.println("刪除書籍後，目前的bookList：" + bookList);

    }
}
