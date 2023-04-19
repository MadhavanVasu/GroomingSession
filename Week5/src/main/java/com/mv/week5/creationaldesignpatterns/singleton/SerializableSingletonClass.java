package com.mv.week5.creationaldesignpatterns.singleton;

import java.io.Serializable;

public class SerializableSingletonClass implements Serializable {

    private static SerializableSingletonClass obj = null;
    private String name;

    // Should have private constructors in singleton class
    private SerializableSingletonClass() {

    }

    private SerializableSingletonClass(String s) {
        this.name = s;

    }

    public String getName() {
        return this.name;
    }

    public static SerializableSingletonClass getInstance(String s) {
        // Not thread safe
        // Because initially two threads can enter inside the if block at the same time
        // and create 2 different instances which breaks the Singleton property.
        if (obj == null) {
            obj = new SerializableSingletonClass(s);
        }
        return obj;
    }

    public Object readResolve() {
        return obj;
    }

}
