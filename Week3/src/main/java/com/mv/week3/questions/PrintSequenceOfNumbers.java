package com.mv.week3.questions;


class PrintNumbersUsingThreads {

    private static final int N = 20;
    private static final int THREAD_COUNT = 3;
    private static int counter = 1;

    public static void main(String[] args) {

        for (int i = 1; i <= THREAD_COUNT; i++) {
            new Thread(new NumberPrinter(i)).start();
        }
    }

    private static class NumberPrinter implements Runnable {

        private final int threadId;

        public NumberPrinter(int threadId) {
            this.threadId = threadId;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (PrintNumbersUsingThreads.class) {
                    if (counter > N) {
                        break;
                    }
                    if (counter % THREAD_COUNT == threadId - 1) {
                        System.out.println("THREAD-" + threadId + " : " + counter);
                        counter++;
                        PrintNumbersUsingThreads.class.notifyAll();
                    } else {
                        try {
                            PrintNumbersUsingThreads.class.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}


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
