package com.mv.week1.strings_immutable_class;

public class StringDemo {

    public static void main(String[] args) {

        // 3 ways to create a String

        // 1. using new keyword
        String s1 = new String("Hello World");

        // 2. assigning a String literal directly
        String s2 = "Hello";

        // 3. Using StringBuilder or StringBuffer
        StringBuilder s3 = new StringBuilder("Madhavan");

        StringBuffer s4 = new StringBuffer();
        System.out.println(s4.capacity());
        s4.append("Hello All");
        System.out.println(s4.capacity());
        s4.append(" hi ");
        System.out.println(s4.capacity());
//        s4 = new StringBuffer("hello all");
//        System.out.println(s4.capacity());
        s4.append("This is a sample long string for testing");
        System.out.println(s4.length() + " " + s4.capacity());


    }

}
