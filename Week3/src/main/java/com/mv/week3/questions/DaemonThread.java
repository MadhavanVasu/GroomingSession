package com.mv.week3.questions;

public class DaemonThread {

    static class Task implements Runnable {

        public void display() {
            System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().isDaemon());
        }

        @Override
        public void run() {
            display();
        }
    }

    public static void main(String[] args) {
        Task task = new Task();
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.setDaemon(true);
        t1.start();
        t2.start();
    }

}
