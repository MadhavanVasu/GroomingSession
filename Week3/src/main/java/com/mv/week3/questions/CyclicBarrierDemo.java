package com.mv.week3.questions;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

// CyclicBarrier is a synchronization aid that allows a set of threads to wait for each other to reach a common execution point.
// It works by creating a barrier that is used to block all participating threads
// until they all reach the barrier point.
// Once all threads have reached the barrier, the barrier is broken, and all threads are allowed to proceed.
// CyclicBarrier takes a number of threads to wait for,
// and a barrier action that is executed once all threads have reached the barrier.
// When a thread reaches the barrier, it blocks until all other threads have also reached the barrier.
// Once all threads have reached the barrier, the barrier action is executed, and the threads are released.
// Unlike countdown latch, cyclic barrier can be reused.

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
