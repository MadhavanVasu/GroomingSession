package com.mv.week3.questions;

public class JoinVsYield {

    static class Task implements Runnable{


        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Thread.yield();
            System.out.println("Task executed " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // When a thread calls the yield() method, it goes from the Running state to the Runnable state.
        // The Running state means that the thread is currently executing its task.
        // By calling yield(), the thread voluntarily gives up the CPU so that other threads can run.
        // The thread then moves to the Runnable state, where it waits for the scheduler to allocate CPU time to it again.
        // The thread which called yield() can again be allocated CPU time.
        Thread t1 = new Thread(new Task());
        Thread t2 = new Thread(new Task());
        t1.setPriority(1);
        t2.setPriority(10);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        // join() method permits one thread to wait until the other thread to finish its execution.
        Thread t3 = new Thread(new Task());
        Thread t4 = new Thread(new Task());
        t3.start();
        t3.join();
        t4.start();
        t4.join();
        System.out.println("Main executed after t3 and t4 has terminated");



    }


}
