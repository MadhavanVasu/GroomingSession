package com.mv.week1.part2;

final class A {

    int a;

    public int b;


    public A(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }


}

public class ImmutableClassDemo {

    public static void main(String[] args) {
        A obj = new A(1, 2);
        System.out.println(obj.a);
        obj.a = 10;
        System.out.println(obj.a);

        obj = new A(1, 3);
        final A obj1 = new A(2, 3);
        obj1.a = 10;

        final StringBuilder sb = new StringBuilder("hi");
        // Won't throw compilation error because we are modifying the value not the reference
        sb.append("hi");

        String s = new String(i);
    }
}
