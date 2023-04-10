package com.mv.week3.questions;


import java.util.LinkedList;
import java.util.Queue;

class CustomBlockingQueue<T> {

    private Queue<T> queue = new LinkedList<>();
    private int capacity;

    public CustomBlockingQueue(int capacity) {
        // Setting the maximum capacity for the queue
        this.capacity = capacity;
    }

    public synchronized void put(T element) throws InterruptedException {
        while (queue.size() == capacity) {
            // Can't insert element if queue is full.
            // Move the producer thread to waiting state if queue is at maximum capacity
            wait();
        }
        queue.offer(element);
        // Once element is added, consumer which is in waiting state(when no queue is empty) is notified.
        notifyAll();
    }

    public synchronized T take() throws InterruptedException {
        while (queue.isEmpty()) {
            // Can't poll element if queue is empty.
            // Move the producer thread to waiting state if queue is at maximum capacity
            wait();
        }
        T element = queue.poll();
        // Once element is consumed, producer which is in waiting state(when no queue is full) is notified.
        notifyAll();
        return element;
    }
}

class ProducerConsumer {

    CustomBlockingQueue<Integer> blockingQueue;
    int producedCount = 0;
    int consumedCount = 0;

    public ProducerConsumer(CustomBlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void produce() throws InterruptedException {
        while (true) {
            if (producedCount == 10) break;
            blockingQueue.put(1);
            System.out.println("Item produced");
            producedCount++;
            Thread.sleep(1000);
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            if (consumedCount == 10) break;
            blockingQueue.take();
            System.out.println("Item consumed");
            consumedCount++;
            Thread.sleep(3000);
        }
    }


}


public class BlockingQueueDemo {

    public static void main(String[] args) {

        CustomBlockingQueue<Integer> blockingQueue = new CustomBlockingQueue<>(5);
        ProducerConsumer producerConsumer = new ProducerConsumer(blockingQueue);
        Thread producerThread = new Thread(() -> {

            try {
                producerConsumer.produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });
        Thread consumerThread = new Thread(() -> {

            try {
                producerConsumer.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });
        producerThread.start();
        consumerThread.start();


    }
}
