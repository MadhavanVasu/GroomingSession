package com.mv.week1.java_constructs_oops.questions;

public class AutoBoxing {

    public static void main(String[] args) {

        //Auto boxing is the automatic conversion of primitive data type to object of its associated wrapper class
        int a = 10;
        Integer b = a;
        System.out.println(b);

        // Unboxing is the automatic conversion of object of wrapper class to its associated primitive data type
        Integer c = 5;
        int d = c;
        System.out.println(d);


    }

}
