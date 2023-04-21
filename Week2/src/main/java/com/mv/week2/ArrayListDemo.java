package com.mv.week2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

//        for (String s : list) {
//            if ("A".equals(s)) {
//                // throws java.util.ConcurrentModificationException
//                list.remove(s);
//            }
//        }
//        System.out.println(list);

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals("B"))
                iterator.remove();
        }
        System.out.println(list);

    }

}
