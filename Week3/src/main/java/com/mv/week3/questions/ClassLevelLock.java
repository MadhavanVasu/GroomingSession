package com.mv.week3.questions;

class Student implements Runnable {

    static Integer count = 1;

//    public void display() throws InterruptedException {
//        // Every class in Java has a unique lock which is nothing but a class level lock.
//        // If a thread wants to execute a static synchronized method, then the thread requires a class level lock.
//        // Once a thread got the class level lock, then it is allowed to execute any static synchronized method of that class.
//        // Once method execution completes automatically thread releases the lock.
//
////        synchronized (count)
//        synchronized (Student.class) {
//            System.out.println("Inside synchronized block " + Thread.currentThread().getName());
//            Thread.sleep(1000);
//            count++;
//        }
//
//    }

    public synchronized void display() throws InterruptedException {
        // Every class in Java has a unique lock which is nothing but a class level lock.
        // If a thread wants to execute a static synchronized method, then the thread requires a class level lock.
        // Once a thread got the class level lock, then it is allowed to execute any static synchronized method of that class.
        // Once method execution completes automatically thread releases the lock.

//        synchronized (count)
//        synchronized (Student.class) {
            System.out.println("Inside synchronized block " + Thread.currentThread().getName());
        Thread.sleep(3000);

        count++;

//        }

    }

    public synchronized void objectMethod() {
        System.out.println("Inside non static method");
        count++;
        System.out.println("Count incremented");
    }

    @Override
    public void run() {
        try {
            display();
            objectMethod();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


public class ClassLevelLock {

    // Synchronization is a modifier that is used for the method and blocks only.
    // With the help of a synchronized modifier, we can restrict a shared resource to be accessed only by one thread.
    // When two or more threads need access to shared resources, there is some loss of data
    // i.e. data inconsistency.
    // The process by which we can achieve data consistency between multiple threads is called Synchronization.
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new Student());
            threads[i] = t;
        }
        for (int i = 0; i < 5; i++) {
            threads[i].start();
        }
        for (int i = 0; i < 5; i++) {
            threads[i].join();
        }
        System.out.println(Student.count);
    }

}
