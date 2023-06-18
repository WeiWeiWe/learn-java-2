package com.practice.pt;

import java.util.ArrayList;

public class ListSample {
    public void sample1() {
        ArrayList bookList = new ArrayList();
        bookList.add("Test1");
        bookList.add("Test2");
        bookList.add(3.1415926f); // 沒特別定義泛型雖然語法上不會錯誤，但如果實際用到非 Float 類型的方法時，就會有錯誤發生！

        Object o1 = bookList.get(0);
        String bookName1 = (String)o1;
        System.out.println(bookName1.substring(0, 1));

        Object o2 = bookList.get(2); // 第 3 個元素是 Float 類型，運行時，會有錯誤發生，為了避免此情況，需要加上泛型進行約束！
        String bookName2 = (String)o2; // 實際運行時，Float 類型無法強制轉成 String 類型，但因為沒加泛型約束，所以這邊沒有出現錯誤！
        System.out.println(bookName2.substring(0, 1));
    }

    public void sample2() {
        ArrayList<String> bookList = new ArrayList();
        bookList.add("Test1");
        bookList.add("Test2");
//        bookList.add(3.1415926f); // 有泛型約束只能是 String 類型，所以這邊會直接產生錯誤提示！
        bookList.add("Test3");

        // 有加泛型約束就可以馬上避免錯誤情況，而且也不需要強制轉型了，因為通常只會約束一種類型！
        String bookName1 = bookList.get(0);
        System.out.println(bookName1.substring(0, 1));

        String bookName2 = bookList.get(2);
        System.out.println(bookName2.substring(0, 1));
    }

    public static void main(String[] args) {
        ListSample listSample = new ListSample();
//        listSample.sample1();
        listSample.sample2();
    }
}
