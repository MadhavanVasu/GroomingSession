package com.mv.week5.creationaldesignpatterns.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ReflectionProblemAndFix {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        System.out.println("Reflection problem in Singleton class");
        reflectionProblem();
        System.out.println();
        System.out.println("Fixing the problem in Reflection");
        reflectionProblemFix();

    }

    public static void reflectionProblem() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        SerializableSingletonClass obj = SerializableSingletonClass.getInstance("Maddy");
        Constructor[] constructors = SerializableSingletonClass.class.getDeclaredConstructors();
        for (Constructor x : constructors)
            x.setAccessible(true);
        System.out.println(Arrays.toString(constructors));
        SerializableSingletonClass newObj = (SerializableSingletonClass) constructors[1].newInstance("New Obj");

        // Here we have two different objects of type SerializableSingletonClass which is a Singleton Class.
        // This breaks the Singleton Property.
        System.out.println(obj.getName());
        System.out.println(obj.hashCode());

        System.out.println(newObj.getName());
        System.out.println(newObj.hashCode());
    }

    public static void reflectionProblemFix() throws InvocationTargetException, InstantiationException, IllegalAccessException {

        EnumSingleton obj = EnumSingleton.MONDAY;
        System.out.println(obj.hashCode());

        Constructor[] constructors = EnumSingleton.class.getDeclaredConstructors();
        for (Constructor x : constructors)
            x.setAccessible(true);
        // Will get IllegalArgumentException
        // Exception in thread "main" java.lang.IllegalArgumentException:
        // Cannot reflectively create enum objects
        // EnumSingleton newObj = (EnumSingleton) constructors[0].newInstance(5);
        // System.out.println(newObj);

        // Also enum takes care of Serialization internally.

    }

}
