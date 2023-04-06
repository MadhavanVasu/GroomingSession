package com.mv.week3.questions;

public class ThreadPriority {

    public static void main(String[] args) {

        Task task = new Task();
        Thread t1 = new Thread(task, "Thread 1");
        Thread t2 = new Thread(task, "Thread 2");
        t2.setPriority(10);
        t1.setPriority(3);
        t1.start();
        t2.start();

    }

}
