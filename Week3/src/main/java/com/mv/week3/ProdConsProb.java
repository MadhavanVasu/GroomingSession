package com.mv.week3;
import java.util.LinkedList;

class ProducerConsumer {
    private LinkedList<Integer> buffer = new LinkedList<>();
    private int capacity = 5;

    // Producer thread adds items to the buffer
    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (this) {
                // Wait if the buffer is full
                while (buffer.size() == capacity) {
                    wait();
                }

                System.out.println("Producer produces: " + value);
                buffer.add(value++);

                // Notify consumer that an item is produced
                notify();

                // Sleep for some time
                Thread.sleep(1000);
            }
        }
    }

    // Consumer thread consumes items from the buffer
    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                // Wait if the buffer is empty
                while (buffer.size() == 0) {
                    wait();
                }

                int value = buffer.removeFirst();
                System.out.println("Consumer consumes: " + value);

                // Notify producer that an item is consumed
                notify();

                // Sleep for some time
                Thread.sleep(1000);
            }
        }
    }
}

public class ProdConsProb {
    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer();

        // Create and start producer thread
        Thread producerThread = new Thread(() -> {
            try {
                pc.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Create and start consumer thread
        Thread consumerThread = new Thread(() -> {
            try {
                pc.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}
