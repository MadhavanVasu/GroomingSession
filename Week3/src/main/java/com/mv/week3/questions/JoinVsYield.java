package com.mv.week3.questions;

public class JoinVsYield {

    public static void main(String[] args) {
        // When a thread calls the yield() method, it goes from the Running state to the Runnable state.
        // The Running state means that the thread is currently executing its task.
        // By calling yield(), the thread voluntarily gives up the CPU so that other threads can run.
        // The thread then moves to the Runnable state, where it waits for the scheduler to allocate CPU time to it again.
        // The thread which called yield() can again be allocated CPU time.
    }


}
