package com.mv.week3.questions;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionException;

class CustomFixedThreadPool {

    int maxThread;
    boolean isRunning;
    BlockingQueue<Runnable> taskQueue;

    class WorkerThread extends Thread {
        @Override
        public void run() {
            // Will execute the submitted tasks until shutdown() is called.
            while (isRunning || !taskQueue.isEmpty()) {
                try {
                    Runnable task = taskQueue.take();
                    task.run();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public CustomFixedThreadPool(int maxThread) {
        this.maxThread = maxThread;
        this.taskQueue = new LinkedBlockingDeque<>();
        this.isRunning = true;
        for (int i = 0; i < this.maxThread; i++) {
            Thread thread = new WorkerThread();
            thread.start();
        }
    }

    public void shutdown() {
        this.isRunning = false;
    }

    public void submit(Runnable task) {
        // Check if shutdown() was called on the thread pool
        // If shutdown was called submission of new tasks should throw RejectionExecutionException.
        // Else task will be submitted
        if (isRunning) {
            taskQueue.add(task);
        } else
            throw new RejectedExecutionException();
    }
}

public class CustomThreadPool {

    static class Task implements Runnable {

        int taskId;

        public Task(int taskId) {
            this.taskId = taskId;
        }

        @Override
        public void run() {
            System.out.println("Task " + taskId + " execution started");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Task " + taskId + " task executed");
        }
    }

    public static void main(String[] args) {
        CustomFixedThreadPool fixedThreadPool = new CustomFixedThreadPool(3);
        for (int i = 1; i <= 5; i++)
            fixedThreadPool.submit(new Task(i));
        fixedThreadPool.shutdown();
        // This statement will cause RejectedExecutionException.
        fixedThreadPool.submit(new Task(6));
    }

}


