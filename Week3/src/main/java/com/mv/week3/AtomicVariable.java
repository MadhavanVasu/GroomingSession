package com.mv.week3;


import java.util.concurrent.atomic.AtomicInteger;



public class AtomicVariable {
    private static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {
        Runnable task = () -> {
            for (int i = 0; i < 5; i++) {
                count.incrementAndGet();
                System.out.println(count + " " + Thread.currentThread().getName());
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count value: " + count.get());
    }
}
