package com.mv.week3.questions;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatch {

    static class Task implements Runnable {

        Integer taskId;
        java.util.concurrent.CountDownLatch latch;


        public Task(Integer taskId, java.util.concurrent.CountDownLatch latch) {
            this.taskId = taskId;
            this.latch = latch;
        }

        public void operation() {
            try {
                Thread.sleep(2000);
                System.out.println("Task " + taskId + " completed");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
                System.out.println("Executing other work...");
            }
        }


        @Override
        public void run() {
            operation();
        }
    }

    public static void main(String[] args) {
        // CountDownLatch is a synchronization aid provided by Java's concurrency library
        // It allows one or more threads to wait until a set of operations being performed in other threads completes.
        // It is used to synchronize the execution of multiple threads.
        // CountDownLatch is used to make sure that a task waits for other threads before it starts.
        // A CountDownLatch is initialized with a count,
        // which is the number of times the countDown() method must be invoked before the threads waiting on the latch can proceed.
        // The threads that call the countDown() method do not block,
        // but the threads waiting on the latch will block until the count reaches zero.
        final java.util.concurrent.CountDownLatch latch = new java.util.concurrent.CountDownLatch(3);
        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 4; i++) {
            executor.submit(new Task(i + 1, latch));
        }

        try {
            // Wait until all tasks are completed
            latch.await();
            System.out.println("All tasks completed");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        // Shutdown the executor
        executor.shutdown();
    }
}
