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
        List<Integer> list2 = Arrays.asList(1,2,3);
//        List<Integer> list2 = Arrays.asList(new Integer[] {1,2,3});
        System.out.println(list2);
//        list2.add(5); -> would cause runtime exception

        // Default capacity is 10
        ArrayList<Integer> aList;
//        HashMap




    }

}
