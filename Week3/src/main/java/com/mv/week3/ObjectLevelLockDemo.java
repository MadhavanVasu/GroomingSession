package com.mv.week3;


class Counter {
    private int count;

    public void increment() throws InterruptedException {
        synchronized (this) {
            count++;
            Thread.sleep(3000);
        }
    }

    //    public int getCount() {
//        return count;
//    }
    public synchronized int getCount() {
        return count;
    }
}

public class ObjectLevelLockDemo {

    // When a synchronized block or method is executed on an object,
    // the object's lock is acquired by the executing thread.
    // Other threads attempting to execute synchronized blocks or methods on the same object will be blocked
    // until the lock is released by the executing thread.
    public static void main(String[] args) {
        Counter obj = new Counter();
        Thread t1 = new Thread(() -> {
            try {
                obj.increment();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(() -> System.out.println(obj.getCount()));

        t1.start();
        t2.start();
    }


}
