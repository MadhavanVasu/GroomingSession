package com.mv.week3.questions;

import java.util.concurrent.Semaphore;

class MySemaphore {

    Semaphore semaphore;

    public MySemaphore(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public void acquire() throws InterruptedException {
        semaphore.acquire();
    }

    public void release() throws InterruptedException {
        semaphore.release();
    }

}

public class SemaphoreDemo {
    static class Task implements Runnable {

        MySemaphore mySemaphore;

        public Task(MySemaphore mySemaphore) {
            this.mySemaphore = mySemaphore;
        }

        @Override
        public void run() {
            try {
                mySemaphore.acquire();
                System.out.println(Thread.currentThread().getName() + " acquired the permit to enter critical section");
                Thread.sleep(2000);
                mySemaphore.release();
                System.out.println(Thread.currentThread().getName() + " released the permit");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Method 1");
        MySemaphore mySemaphore = new MySemaphore(new Semaphore(3));
        Task task = new Task(mySemaphore);
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(task);
            thread.start();
            threads[i] = thread;
        }
        for (int i = 0; i < 5; i++) threads[i].join();

        System.out.println("Method 2");
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {

                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + " acquired the permit to enter critical section");
                    Thread.sleep(2000);
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName() + " released the permit");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            });
            thread.start();
        }
    }
}
