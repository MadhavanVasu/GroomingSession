package com.mv.week2.questions;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

// Write a program to sort the objects in desc order using TreeMap

// Write a program for the custom sort using Comparator in TreeMap.

// Implementing Comparable interface
class Student implements Comparable {

    int sid;
    String name;

    public Student(int sid, String name) {
        this.sid = sid;
        this.name = name;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Student obj = (Student) o;
        if (obj.getSid() > getSid())
            return -1;
        else if (obj.getSid() < getSid())
            return 1;
        return 0;
    }
}


public class TreeMapDemo {

    public static void main(String[] args) {
        // TreeMap implements NavigableMap interface.
        // Its internal working on the principles of red-black trees.
        // Red-black tree is a self-balancing binary search tree.
        // This attribute and the above guarantee that basic operations
        // like search, get, put and remove take logarithmic time O(log n).
        Map<Integer, Integer> map = new TreeMap<>();
        map.put(1, 10);
        map.put(2, 5);
        map.put(10, 3);
        map.put(4, 1);
        // By default sorts based on the key value
        System.out.println(map);

        // Comparator -> for sorting based on Student ID
        Comparator<Student> studentComparator1 = Comparator.comparingInt(Student::getSid);

        // Comparator -> for sorting based on Student name lexicographically
        Comparator<Student> studentComparator2 = Comparator.comparing(Student::getName);
        Map<Student, Integer> studentMap1 = new TreeMap<>(studentComparator1);
        Map<Student, Integer> studentMap2 = new TreeMap<>(studentComparator2);
        // Construction of sorted collection with non-comparable elements
        // Because user-defined data types like class have no natural ordering
        // So should either implement Comparable interface or pass object of type Comparator to TreeMap constructor.
        Map<Student, Integer> studentMap3 = new TreeMap<>();

        Student s1 = new Student(1, "Maddy");
        Student s2 = new Student(2, "Vijay");
        Student s3 = new Student(3, "Mark");
        Student s4 = new Student(4, "Arjun");

        studentMap1.put(s1, 90);
        studentMap1.put(s2, 80);
        studentMap1.put(s3, 85);
        studentMap1.put(s4, 70);

        studentMap2.put(s1, 90);
        studentMap2.put(s2, 80);
        studentMap2.put(s3, 85);
        studentMap2.put(s4, 70);

        studentMap3.put(s1, 90);
        studentMap3.put(s2, 80);
        studentMap3.put(s3, 85);
        studentMap3.put(s4, 70);

        System.out.println(studentMap1);
        System.out.println(studentMap2);
        System.out.println(studentMap3);

        Map<Integer, Integer> descMap = new TreeMap<>(Collections.reverseOrder());
        descMap.put(1, 10);
        descMap.put(2, 5);
        descMap.put(10, 3);
        descMap.put(4, 1);
        // Sorting the map in reverse order using Collections.reverseOrder()
        System.out.println(descMap);
    }

}
