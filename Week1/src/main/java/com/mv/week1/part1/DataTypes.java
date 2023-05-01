package com.mv.week1.part1;

public class DataTypes extends Object {

    public static class A {

        boolean bool;

        char ch;

        byte b;

        short x;

        int a;

        long l;

        float f;

        double d;

        String s;

    }


    static int y = 4;

    public static void main(String[] args) {

        // Primitive data types:
        // The primitive data types include boolean, char, byte, short, int, long, float and double.

        boolean bool;
        // If we try to access a local variable without an initial value, we'll get an error.
        //System.out.println(bool);

        A obj = new A();

        // Default value for boolean is false
        System.out.println(obj.bool);

        // Default value for byte is 0
        System.out.println(obj.b);

        // Default value for ch '\u0000'
        System.out.println(obj.ch);

        // Default value for short 0
        System.out.println(obj.x);

        // Default value for int 0
        System.out.println(obj.a);

        // Default value for float 0.0f
        System.out.println(obj.f);

        // Default value for double 0.0
        System.out.println(obj.d);

        // Default value for long 0
        System.out.println(obj.l);

        // Default value for String and objects of other classes is null
        System.out.println(obj.s);

        // Wrapper Class
        Integer a;





    }

}
