package com.mv.week3.questions;


public class ThreadInterrupt {

    public static void main(String[] args) {
        Task task = new Task();
        Thread t1 = new Thread(task, "Thread 1");
        Thread t2 = new Thread(task, "Thread 2");
        t1.start();
        // Interrupts are often used to signal a running thread to stop what it's doing and terminate early
        // But it's up to the thread to decide how to respond to the interrupt.
        // The interrupt() method of thread class is used to interrupt the thread.
        // If any thread is in sleeping or waiting state (i.e. sleep() or wait() is invoked)
        // Then using the interrupt() method, we can interrupt the thread execution by throwing InterruptedException.
        //If the thread is not in the sleeping or waiting state
        // Then calling the interrupt() method performs a normal behavior
        // Doesn't interrupt the thread but sets the interrupt flag to true.
        t1.interrupt();
        t2.start();
    }

}
