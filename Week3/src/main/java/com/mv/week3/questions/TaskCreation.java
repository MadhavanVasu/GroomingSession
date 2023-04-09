package com.mv.week3.questions;

class Task implements Runnable {

    public void display() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
//            if (Thread.interrupted()) return;
            System.out.println("Display() " + i + " from " + Thread.currentThread().getName());
            try {
                // sleep(time) is used pause the execution for a specified amount of time
                // It does not release the lock its holding
                // There is no notify() or notifyAll() for sleep()
                // When sleep() method is invoked, the thread goes into the TIMED_WAITING state.
                // This means that the thread is still alive
                // Waiting for a specific period of time before it can continue executing its tasks.
                // During this time, the thread is temporarily blocked
                // Gives up the CPU to other threads that are ready to run.
                // Once the specified time has elapsed, the thread returns to the RUNNABLE state
                // Continues executing its tasks.
                Thread.sleep(1000);
            } catch (InterruptedException e) {
//                System.out.println(Thread.currentThread().getName() + " interrupted");
                throw new InterruptedException("Thread interrupted");
            }
        }
    }

    public void display2() {
//        System.out.println(Thread.currentThread().isInterrupted());

        for (int i = 0; i < 5; i++) {
            System.out.println("Display2() " + i + " from " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupted");
            }
        }
    }

    @Override
    public void run() {
//        try {
//            display();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        System.out.println("Inside run " + Thread.currentThread().getName());
        display2();

    }
}

public class TaskCreation {

    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();
        Thread t1 = new Thread(task, "Thread t1");
        Thread t2 = new Thread(task, "Thread t2");

        t1.start();
        t1.join();
        t2.start();

    }


}
