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

    public static void main(String[] args) {
        MySemaphore mySemaphore = new MySemaphore(new Semaphore(3));
        Task task = new Task(mySemaphore);
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(task);
            thread.start();
        }
    }
}
