package com.mv.week5.creationaldesignpatterns.singleton;

public class CloneableSingleton implements Cloneable {

    private static CloneableSingleton obj = null;
    private String name;

    // Should have private constructors in singleton class
    private CloneableSingleton() {

    }

    private CloneableSingleton(String s) {
        this.name = s;

    }

    public String getName() {
        return this.name;
    }

    public static CloneableSingleton getInstance(String s) {
        // Not thread safe
        // Because initially two threads can enter inside the if block at the same time
        // and create 2 different instances which breaks the Singleton property.
        if (obj == null) {
            obj = new CloneableSingleton(s);
        }
        return obj;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

}
