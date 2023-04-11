package com.mv.week3.questions;


public class ThreadLocalDemo {
    static class Task implements Runnable {

        private ThreadLocal<Integer> localVar = new ThreadLocal<Integer>() {
            @Override
            protected Integer initialValue() {
                return 0;
            }
        };

        public Task() {
            localVar.set(0);
        }

        public void incrementCount() {
            int count = localVar.get();
            for (int i = 0; i < 5; i++)
                count++;
            localVar.set(count);
        }

        public void displayCount() {
            System.out.println(Thread.currentThread().getName() + " " + localVar.get());
        }


        @Override
        public void run() {
            incrementCount();
            displayCount();
        }
    }

    public static void main(String[] args) {
        Task task = new Task();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(task);
            thread.start();
        }
    }

}
