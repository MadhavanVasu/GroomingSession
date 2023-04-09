package com.mv.week3;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class CountDownLatchDemo {

    static class Task implements Runnable {

        Integer taskId;
        CountDownLatch latch;


        public Task(Integer taskId, CountDownLatch latch) {
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
            }
        }


        @Override
        public void run() {
            operation();
        }
    }

    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(3);
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
