package com.mv.week4;

import java.util.concurrent.*;

class ForkJoinSumCalculator extends RecursiveTask<Long> {
    private final int[] numbers;
    private final int start;
    private final int end;
    private static final int THRESHOLD = 5; // Threshold for splitting the task

    public ForkJoinSumCalculator(int[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length = end - start;
        System.out.println(length + " " + start + " " + end);
        if (length <= THRESHOLD) { // If the task is small enough, compute it sequentially
            return computeSequentially();
        }
        int split = start + length / 2; // Split the task into two halves
        ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, split); // Create a new task for the left half
        leftTask.fork(); // Fork the left half of the task, submitting it to the ForkJoinPool for execution
        ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, split, end); // Create a new task for the right half
        Long rightResult = rightTask.compute(); // Compute the right half of the task recursively
        Long leftResult = leftTask.join(); // Join the result of the left half, waiting for it to complete if necessary
        return leftResult + rightResult; // Combine the results of the left and right halves to compute the final sum
    }

    private long computeSequentially() {
        long sum = 0;
        for (int i = start; i < end; i++) { // Compute the sum sequentially
            sum += numbers[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        // Create an array of integers
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

        // Create a ForkJoinPool with the default number of threads
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

        // Create a ForkJoinSumCalculator for the entire array
        ForkJoinSumCalculator task = new ForkJoinSumCalculator(numbers, 0, numbers.length);

        // Submit the task to the ForkJoinPool and obtain a Future object for the result
        Future<Long> result = forkJoinPool.submit(task);

        try {
            // Wait for the result and print it
            System.out.println("Sum: " + result.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}


