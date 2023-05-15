package com.mv.week2;

import java.util.*;

public class CollectionsDemo {

    class Student {
        Integer studentId;
        String name;

        public Student(Integer studentId, String name) {
            this.studentId = studentId;
            this.name = name;
        }
    }


    public static void main(String[] args) {

        // Returns an immutable list
        List<Integer> list = List.of(1, 2, 3);
        System.out.println(list);

        // Takes args of objects or array of objects and converts to immutable list
        List<Integer> list2 = Arrays.asList(1, 2, 3);
//        List<Integer> list2 = Arrays.asList(new Integer[] {1,2,3});
        System.out.println(list2);
//        list2.add(5); -> would cause runtime exception

        // Default capacity is 10
        ArrayList<Integer> aList;
        HashMap<String, Integer> map = new HashMap<>();
        Set<String> set = map.keySet();
        Collection<Integer> valueSet = map.values();

        List<Integer> linkedList = new LinkedList<>();
        linkedList.add(null);
        linkedList.add(null);
        linkedList.add(null);
        System.out.println(linkedList);

        // Does not allow null values -> ArrayDeque
//        ArrayDeque<Integer> arrDq = new ArrayDeque<>();
//        arrDq.add(null);

//
        TreeMap<String, Integer> treeMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1 == null && s2 == null) {
                    return 0;
                } else if (s1 == null) {
                    return -1;
                } else if (s2 == null) {
                    return 1;
                } else {
                    return s1.compareTo(s2);
                }
            }
        });

        treeMap.put("apple", 1);
        treeMap.put(null, 2);
        treeMap.put("banana", 3);
        treeMap.put(null, 4);

        System.out.println(treeMap); // Output: {apple=1, banana=3, null=4}




    }

}
