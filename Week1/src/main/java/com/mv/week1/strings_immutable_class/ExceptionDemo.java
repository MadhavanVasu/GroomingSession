package com.mv.week1.strings_immutable_class;

import java.io.*;

public class ExceptionDemo {

    public static void main(String[] args) throws IOException {
        System.out.println(1/0);
        // throw new RuntimeException();
        try {
            throw new RuntimeException();
        } catch (Exception e) {
            e.getStackTrace();
        }
        System.out.println("Outside try-catch");


        // "D:\\testout.txt"
        // FileNotFoundException -> Checked exception -> Subclass of IOException
        // try with resources -> this removes the necessity of adding finally block for closing file
        // It automatically closes the resource
        // Resources need to implement AutoCloseable Interface
        try (FileReader f = new FileReader("D:\\testout.txt")) {
            System.out.println("Hi");
        }




    }
}


