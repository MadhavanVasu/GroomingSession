package com.mv.week3.questions;


class CounterTask implements Runnable {

    static Integer count = 1;
    static int THREAD_COUNT = 3;
    static int n = 10;

    private int threadId;

    public CounterTask(int threadId) {
        this.threadId = threadId;
    }


    public void incrementCount() throws InterruptedException {
        while (true) {
            synchronized (CounterTask.class) {
                if (count > n)
                    break;
                if (count % THREAD_COUNT == threadId % THREAD_COUNT) {
                    System.out.println("Thread " + threadId + " " + count);
                    count++;
                    CounterTask.class.notifyAll();
                } else {
                    CounterTask.class.wait();
                }
            }

        }

    }


    @Override
    public void run() {
        try {
            incrementCount();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class PrintSequenceOfNumbers {

    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {
            Thread t = new Thread(new CounterTask(i + 1));
            t.start();
        }
    }

}
