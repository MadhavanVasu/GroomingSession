package com.mv.week1.part1.questions;

class Child1 extends InheritanceA {

}

public class InheritanceB {

    public static void main(String[] args) {

        Child1 child = new Child1();

        // Can access public, protected, default methods if the child class is within the same package
        // Cannot access private method outside the parent class
        child.displayDefaultMethod();
        child.displayPublicMethod();
        child.displayProtectedMethod();


    }

}

