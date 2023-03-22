package com.mv.week1.part1.questions;

class A {

    public int a;

    protected int b;

    private int c;

    int d;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    protected int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    int getD() {
        return d;
    }

    void setD(int d) {
        this.d = d;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }
}

public class AccessModifier {

    public static void main(String[] args) {

        A obj = new A();

        // Can access public fields and methods outside the class
        obj.a = 1;
        System.out.println(obj.getA());

        // Can access protected field or methods anywhere within the package
        // Outside package only if it is inherited
        obj.b = 2;
        System.out.println(obj.getB());

        // Cannot access private members outside the class.
        // obj.c = 5;

        // Can access default members within the package
        // Cannot be access anywhere outside the package
        obj.d = 10;
        System.out.println(obj.getD());

    }
}
