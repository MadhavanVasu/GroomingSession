package com.mv.week3.questions;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CreateThreadPool {

    public static void main(String[] args) {
        // Creates a thread pool that reuses a fixed number of threads
        // Operating off a shared unbounded queue.
        // At any point, at most nThreads threads will be active processing tasks.
        // If additional tasks are submitted when all threads are active, they will wait in the queue until a thread is available.
        // If any thread terminates due to a failure during execution prior to shutdown, a new one will take its place if needed to execute subsequent tasks.
        // The threads in the pool will exist until it is explicitly shutdown.
        ExecutorService service = Executors.newFixedThreadPool(5);

//         Fixed thread pool uses LinkedBlockingQueue for queueing tasks.
//         An optionally-bounded blocking queue based on linked nodes.
//         This queue orders elements FIFO (first-in-first-out).
//         The head of the queue is that element that has been on the queue the longest time.
//         The tail of the queue is that element that has been on the queue the shortest time.
//         New elements are inserted at the tail of the queue, and the queue retrieval operations obtain elements at the head of the queue.
//         The optional capacity bound constructor argument serves as a way to prevent excessive queue expansion.
//         The capacity, if unspecified, is equal to Integer.MAX_VALUE. (2^31-1)
//         Linked nodes are dynamically created upon each insertion unless this would bring the queue above capacity.
        for (int i = 0; i < 10; i++) {
            // In ExecutorService, execute() and submit() are two methods used for submitting tasks to the executor for execution.
            // The main difference between them is that execute() doesn't return any result,
            // while submit() returns a Future object.

            // The execute() method takes a Runnable as an argument and starts executing it asynchronously.
            // It doesn't return any value, and if the task throws any exception, it is lost.
            // The calling code won't be notified.

            //On the other hand, submit() method can take both Runnable and Callable as an argument
            // and returns a Future object.
            // The Future object allows the calling code to retrieve the result of the executed task or to check its status.
            // If the task throws an exception, it is wrapped in the ExecutionException
            // The calling code can catch it.
            service.execute(new Task());
        }
        System.out.println("In main");
        service.shutdown();
        service.submit(new Task());

    }

}
