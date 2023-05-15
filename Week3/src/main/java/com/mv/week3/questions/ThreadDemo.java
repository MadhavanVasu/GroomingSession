package com.mv.week3.questions;

class A extends Thread {

    public void display() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hi from A");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException("Thread " + Thread.currentThread().getName() + " interrupted");

            }
        }
    }

    @Override
    public void run() {
        try {
            display();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

}

class B extends Thread {

    public void display() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hi from B");
            sleep(500);
        }
    }

    @Override
    public void run() {
        try {
            display();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}

public class ThreadDemo {

    public static void main(String[] args) {

        A t1 = new A();
        B t2 = new B();
        System.out.println(t1.getState());
        t1.start();
        System.out.println(t1.getState());
        t2.start();

    }

}
