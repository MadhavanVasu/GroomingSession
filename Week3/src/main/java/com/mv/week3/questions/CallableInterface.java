package com.mv.week3.questions;

import java.util.Scanner;
import java.util.concurrent.*;


public class CallableInterface {

    static class Task implements Callable<Integer> {

        public Integer sumOfNNumbers(int n) throws InterruptedException {
            Integer sum = 0;
            for (int i = 1; i <= n; i++)
                sum += i;
            Thread.sleep(2000);
            return sum;
        }

        @Override
        public Integer call() throws Exception {
            int n;
            Scanner sc = new Scanner(System.in);
            n = sc.nextInt();
            return sumOfNNumbers(n);
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Task task = new Task();
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> result = executor.submit(task);
        // get() method in Callable interface is a blocking call.
        // A blocking call is a type of function or method call that does not return control to the calling program
        // Until a specific event has occurred or a certain condition is met.
        // While the call is being processed, the calling thread is blocked and cannot proceed with any other activities.
        // Example of a blocking call is waiting for user input from the console.
        // Blocking calls are commonly used in programming when there is a need to wait for some external event
        // Or condition before proceeding with the next step in the program.
        // However, excessive use of blocking calls can lead to poor program performance and responsiveness,
        // as the calling thread is unable to perform other tasks while waiting for the blocking call to complete.
//        System.out.println(result.get());
//        System.out.println("Blocking call");
        while (!result.isDone()) ;
        System.out.println(result.get());
        executor.shutdown();
    }

}
