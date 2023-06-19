package com.practice.pt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

// 實現隨機選擇 List 中的元素
public class CollectionUtils<E> {
    private List<E> data = new ArrayList();

    public void add(E element) {
        data.add(element);
    }

    public E randomSelect() {
        int idx = new Random().nextInt(data.size());
        E ret = data.get(idx);
        return ret;
    }

    public static void main(String[] args) {
        CollectionUtils<String> utils = new CollectionUtils();
        utils.add("Test1");
        utils.add("Test2");
        utils.add("Test3");
        utils.add("Test4");
        utils.add("Test5");
        String name = utils.randomSelect();
        System.out.println(name);

    }
}
