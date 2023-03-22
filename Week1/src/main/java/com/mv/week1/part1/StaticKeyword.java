package com.mv.week1.part1;

// The static keyword in Java is used for memory management mainly.
// We can apply static keyword with variables, methods, blocks and nested classes.
// The static keyword belongs to the class than an instance of the class.

class Human {

    String name;
    int age;
    static int population;

    static {
        population = 0;
        System.out.println("In static block");
    }

    public Human(String name, int age) {

        System.out.println("In constructor");
        this.name = name;
        this.age = age;

        // Can access static variable using both this keyword and class name.
//        this.population+=1;
        Human.population += 1;

    }

}

public class StaticKeyword {

    public static void main(String[] args) {

        Human human1 = new Human("Vijay", 22);
        Human human2 = new Human("Matt Murdock", 30);

        // Can access using both object and class name.
//        System.out.println(human1.population);
        System.out.println(Human.population);

    }


}
