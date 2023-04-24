package com.mv.week5.creationaldesignpatterns.singleton;


import java.io.Serializable;

public class LazySingletonClass implements Serializable, Cloneable {

    private static LazySingletonClass obj = null;
    private String name;

    // Should have private constructors in singleton class
    private LazySingletonClass() {

    }

    private LazySingletonClass(String s) {
        this.name = s;

    }

    public String getName() {
        return this.name;
    }

    public static LazySingletonClass getInstance(String s) {
        // Not thread safe
        // Because initially two threads can enter inside the if block at the same time
        // and create 2 different instances which breaks the Singleton property.

        // Singleton Example : Logging, DB Connection
        if (obj == null) {
            obj = new LazySingletonClass(s);
        }
        return obj;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}

class LazySingletonClassDemo {

    public static void main(String[] args) {
        // Shows compile time error
        // LazySingletonClass obj = new LazySingletonClass();
        LazySingletonClass obj1 = LazySingletonClass.getInstance("Maddy");
        LazySingletonClass obj2 = LazySingletonClass.getInstance("Vijay");

        System.out.println(obj1.getName());
        System.out.println(obj2.getName()); // Prints Maddy

    }

}
