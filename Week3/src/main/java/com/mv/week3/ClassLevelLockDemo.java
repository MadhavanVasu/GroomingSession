package com.mv.week3;

import java.util.List;

class CounterClassLevel {
    private static int count;
    private Object lock = new Object();

    // When lock is acquired on a different object we can access other synchronized methods of the current object
//    public void increment() throws InterruptedException {
//        synchronized (lock) {
//            count++;
//            Thread.sleep(3000);
//        }
//    }

    // 1 2 3 4
    // 2 4 6 8
    public static synchronized void increment() throws InterruptedException {
        System.out.println("Inside increment()");
        Thread.sleep(5000);
        count++;
        Thread.sleep(10000);
    }

    //    public int getCount() {
//        return count;
//    }
    // synchronized -> lock on this object
    // static synchronized -> lock on Classname.class object (Class object)
    public synchronized int getCount() throws InterruptedException {
        System.out.println("Inside getCount() method " + count);
        Thread.sleep(1000);
        return count;
    }
}


public class ClassLevelLockDemo {
    public static void main(String[] args) {
        CounterClassLevel obj = new CounterClassLevel();
        CounterClassLevel obj1 = new CounterClassLevel();
        Thread t1 = new Thread(() -> {
            try {
                obj.increment();
//                obj.getCount();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(() -> {
            try {
//                Thread.sleep(2000);
                obj1.getCount();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();
        t2.start();
    }
}


class CounterList {
    private static int count;
    private static List<Integer> list;

    // When lock is acquired on a different object we can access other synchronized methods of the current object
//    public void increment() throws InterruptedException {
//        synchronized (lock) {
//            count++;
//            Thread.sleep(3000);
//        }
//    }

    // 1 2 3 4
    // 2 4 6 8
    public void increment() throws InterruptedException {
        synchronized (CounterList.class) {
            System.out.println("Inside synchronized block class level");
            count++;
            Thread.sleep(3000);
        }
    }

    //    public int getCount() {
//        return count;
//    }
    public static synchronized int getCount() throws InterruptedException {
        System.out.println("Inside synchronized method");
        Thread.sleep(1000);
        return count;
    }
}
