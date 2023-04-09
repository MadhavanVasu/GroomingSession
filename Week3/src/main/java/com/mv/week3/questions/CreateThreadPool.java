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
        for (int i = 0; i < 10; i++) {
            service.execute(new Task());
        }
        System.out.println("In main");
        service.shutdown();

    }

}
