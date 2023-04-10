package com.mv.week3.questions;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FutureArrayList {

    static class Task implements Callable<String> {

        @Override
        public String call() throws Exception {
            Thread.sleep(2000);
            return Thread.currentThread().getName();
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        List<Future<String>> list = new ArrayList<>();
//        List<FutureTask> list2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Task task = new Task();
            list.add(fixedThreadPool.submit(task));
        }
        System.out.println(list.get(1).get());
        fixedThreadPool.shutdown();
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        List<Future<String>> list2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Task task = new Task();
            list2.add(cachedThreadPool.submit(task));
        }
        System.out.println(list2.get(2).get());
        cachedThreadPool.shutdown();
    }

}
