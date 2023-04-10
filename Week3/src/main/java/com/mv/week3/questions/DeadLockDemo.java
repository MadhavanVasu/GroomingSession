package com.mv.week3.questions;

import java.util.ArrayList;
import java.util.List;

class Test {

    List<Integer> list1;
    List<Integer> list2;

    public Test(List<Integer> list1, List<Integer> list2) {
        this.list1 = list1;
        this.list2 = list2;
    }

    public void method1() throws InterruptedException {
        Thread.sleep(600);
        synchronized (this.list1) {
            System.out.println("Inside method 1 acquired first lock");
            Thread.sleep(1000);
            synchronized (this.list2) {
                System.out.println("Inside method 1 acquired second lock");
            }
        }
    }

    public void method2() throws InterruptedException {
        Thread.sleep(500);
        synchronized (this.list2) {
            System.out.println("Inside method 2 acquired first lock");
            Thread.sleep(1000);
            synchronized (this.list1) {
                System.out.println("Inside method 2 acquired second lock");
            }
        }
    }

}

public class DeadLockDemo {

    public static void main(String[] args) {
        Test obj = new Test(new ArrayList<>(), new ArrayList<>());
        Thread t1 = new Thread(() -> {
            try {
                obj.method1();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                obj.method2();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        t2.start();

    }

}
