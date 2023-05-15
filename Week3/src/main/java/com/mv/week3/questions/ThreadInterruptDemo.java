package com.mv.week3.questions;

public class ThreadInterruptDemo {
    static class Task implements Runnable {
        public void run() {
            try {
                System.out.println("Thread started...");
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("Thread is running...");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted...");
                System.out.println(Thread.currentThread().isInterrupted());
                // When the interrupt is caught by the catch block, we handle the exception
                // And then re-interrupt the thread using the interrupt() method.
                // This is necessary because the InterruptedException clears the interrupt flag.
                // So we need to set it again if we want to check the interrupt status later.
                Thread.currentThread().interrupt();
            }
            System.out.println("Thread is terminated...");
        }
    }

    public static void main(String[] args) {
        Task task = new Task();
        Thread t = new Thread(task);
        t.start();
        try {
            Thread.sleep(5000);
            // Calling interrupt() does not immediately terminate the thread.
            // But rather sets a flag that can be checked by the thread.
            // It is up to the thread to decide how to handle the interrupt and whether or not to terminate.
            t.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
