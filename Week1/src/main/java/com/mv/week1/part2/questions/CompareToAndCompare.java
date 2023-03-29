package com.mv.week1.part2.questions;

import java.util.Comparator;

class Person implements Comparable<Person> {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Implementing the Comparable interface
    @Override
    public int compareTo(Person obj) {
        if(age>obj.age)
            return 1;
        else if(age<obj.age)
            return -1;
        return 0;

    }

}


public class CompareToAndCompare {
    public static void main(String[] args) {
        Person p1 = new Person("John", 25);
        Person p2 = new Person("Jane", 30);
        Person p3 = new Person("Jim", 20);

        // Implementing the Comparator interface
        // We go for comparator when the ordering of the class is inconsistent
        // i.e. each time we compare using different fields
        Comparator<Person> nameComparator = (person1, person2) -> person1.name.compareTo(person2.name);

        // compareTo() method -> Comparable interface
        // We go for comparable when the ordering is consistent
        System.out.println("Comparing p1 to p2: " + p1.compareTo(p2)); // Output: -1
        System.out.println("Comparing p1 to p3: " + p1.compareTo(p3)); // Output: 1
        System.out.println("Comparing p2 to p3: " + p2.compareTo(p3)); // Output: 1

        // compare() method -> Comparator interface
        System.out.println("Comparing p1 to p2 using NameComparator: " + nameComparator.compare(p1, p2)); // Output: -13
        System.out.println("Comparing p1 to p3 using NameComparator: " + nameComparator.compare(p1, p3)); // Output: 7
        System.out.println("Comparing p2 to p3 using NameComparator: " + nameComparator.compare(p2, p3)); // Output: -4
    }
}
