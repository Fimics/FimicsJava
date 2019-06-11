package com.mic.thread.executor;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WorkstealingPool {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService work = Executors.newWorkStealingPool();

        List<Callable<String>> callableList= IntStream.rangeClosed(0, 20).boxed().map(i ->
            (Callable<String>)() -> {
                System.out.println("Thread "+Thread.currentThread().getName());
               TimeUnit.SECONDS.sleep(1);
               return "Task-"+i;
            }
        ).collect(Collectors.toList());

        work.invokeAll(callableList);
    }
}
