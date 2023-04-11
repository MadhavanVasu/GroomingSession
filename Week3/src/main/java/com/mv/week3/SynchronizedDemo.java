package com.mv.week3;


class ExampleClass {
    private int count = 0;
    private Object obj = new Object();

    public synchronized void increment() throws InterruptedException {
        count++;
        System.out.println(Thread.currentThread().getName() + " incremented count to " + count);
        Thread.sleep(5000);

    }

//    public void printCount() {
//        System.out.println(Thread.currentThread().getName() + " count is " + count);
//    }
    public void printCount() {
        System.out.println(Thread.currentThread().getName() + " count is " + count);
    }
}

public class SynchronizedDemo {
    public static void main(String[] args) throws InterruptedException {
        ExampleClass example = new ExampleClass();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    example.increment();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                example.printCount();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        example.printCount();
    }
}
