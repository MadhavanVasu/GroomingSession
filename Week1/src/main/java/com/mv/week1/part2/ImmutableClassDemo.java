package com.mv.week1.part2;

final class A {

    private final int a;

    private final int b;


    public A(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }
}

public class ImmutableClassDemo {

    public static void main(String[] args) {
        A obj = new A(1, 2);
        System.out.println(obj.getA());

        final StringBuilder sb = new StringBuilder("hi");
        // Won't throw compilation error because we are modifying the value not the reference
        sb.append("hi");

    }
}
