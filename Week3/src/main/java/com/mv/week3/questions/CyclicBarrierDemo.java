package com.mv.week3.questions;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


public class CyclicBarrierDemo {

    static class Task implements Runnable {

        CyclicBarrier cyclicBarrier;

        public Task(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                System.out.println("Thread " + Thread.currentThread().getName() + " is waiting at the barrier.");
                cyclicBarrier.await();
                System.out.println("Thread " + Thread.currentThread().getName() + " has passed the barrier.");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        int numberOfThreads = 5;
        Runnable barrierAction = () -> System.out.println("All threads have reached the barrier");
        CyclicBarrier cyclicBarrier = new java.util.concurrent.CyclicBarrier(numberOfThreads, barrierAction);

        for (int i = 0; i < numberOfThreads; i++) {
            Thread thread = new Thread(new Task(cyclicBarrier));
            thread.start();
        }
    }
}
