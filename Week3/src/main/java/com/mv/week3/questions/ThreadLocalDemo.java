package com.mv.week3.questions;


public class ThreadLocalDemo {
    static class Task implements Runnable {

        // Thread local provides a way to create thread-local variables,
        // which are variables that are local to each thread and are not shared among threads.
        // Each thread has its own copy of the thread-local variable,
        // which is stored in a separate memory space specific to that thread.
        // It has methods like get(), set(), remove().
        // The get() method retrieves the value of the thread-local variable for the calling thread
        // The set() method sets the value of the thread-local variable for the calling thread
        // The remove() method removes the value of the thread-local variable for the calling thread.
        private ThreadLocal<Integer> localVar = new ThreadLocal<Integer>() {
            // Anonymous inner class
            // Here we are overriding the ThreadLocal class' initial value method as it returns null.
            // Here instead we are returning 0.
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
