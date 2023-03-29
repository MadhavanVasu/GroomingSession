package com.mv.week1.java_constructs_oops.questions;


// Outer class can have only public and default access modifier for class
// Inner class can have any of the access modifier
public class InheritanceA {

    private void displayPrivateMethod() {
        System.out.println("Private method in parent class");
    }

    protected void displayProtectedMethod() {
        System.out.println("Protected method in parent class");
    }

    public void displayPublicMethod() {
        System.out.println("Public method in parent class");
    }

    void displayDefaultMethod() {
        System.out.println("Default method in parent class");
    }
}
