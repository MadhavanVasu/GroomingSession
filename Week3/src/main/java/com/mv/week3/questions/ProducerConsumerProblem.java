package com.mv.week3.questions;

import java.util.LinkedList;
import java.util.Queue;

class ProducerConsumerExample {
    private static final int BUFFER_SIZE = 10;

    private static int produced = 0;
    private static int consumed = 0;
    private static final Queue<Integer> buffer = new LinkedList<>();
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread producerThread = new Thread(() -> {
            int value = 1;
            while (true) {
                synchronized (lock) {
                    if (produced == 10) {
                        lock.notifyAll();
                        break;
                    }
                    while (buffer.size() == BUFFER_SIZE) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    buffer.add(value);
                    produced++;
                    System.out.println("Producer value : " + value++);
                    lock.notifyAll();
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread consumerThread = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (consumed == 10) {
                        lock.notifyAll();
                        break;
                    }
                    while (buffer.size() == 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    int value = buffer.poll();
                    System.out.println("Consumer value got : " + value);
                    consumed++;
                    lock.notifyAll();

                }

            }
        });

        producerThread.start();
        consumerThread.start();
    }
}

public class ProducerConsumerProblem {
}
