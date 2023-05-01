package com.mv.week2;

import java.util.*;

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
//        list.add("D"); // ConcurrentModificationException
        while (iterator.hasNext()) {
            if (iterator.next().equals("B"))
                iterator.remove();
            System.out.println(iterator);
        }
        System.out.println(list);


        Set<Integer> set = new HashSet<>(List.of(1, 2, 3));
        Map<Integer, Integer> map = new HashMap<>();
        Iterator<Integer> setIterator = set.iterator();
        Iterator<Integer> keyIterator = map.keySet().iterator();
    }

}
