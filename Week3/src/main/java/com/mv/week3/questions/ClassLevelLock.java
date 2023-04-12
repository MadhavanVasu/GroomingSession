package com.mv.week3.questions;

class Student implements Runnable {

    static int count = 1;
    static Object obj = new Object();

    public void display() throws InterruptedException {
        // Every class in Java has a unique lock which is nothing but a class level lock.
        // If a thread wants to execute a static synchronized method, then the thread requires a class level lock.
        // Once a thread got the class level lock, then it is allowed to execute any static synchronized method of that class.
        // Once method execution completes automatically thread releases the lock.
        // Static variables in Java are shared by all instances of a class
        // and are stored in the class's memory space, not in the local cache of individual threads.
        // unprotected modification of shared state isn't guaranteed to be visible in other threads
        // without setting up appropriate memory barriers.
        // It's entirely fine for those changes to be visible to other threads immediately - it's just not guaranteed.
        // A race condition occurs when two or more threads can access shared data,
        // and they try to change it at the same time.
        // We use synchronisation to avoid race condition.
        // Can acquire class level lock using static object as monitor or using class name.
        // synchronized (obj) or synchronized(Classname.class)
        synchronized (Student.class) {
            System.out.println("Inside synchronized block " + Thread.currentThread().getName());
            Thread.sleep(1000);
            count++;
            System.out.println("Count incremented in display()");
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
