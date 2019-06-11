package com.mic.thread.executor;

import java.util.List;
import java.util.concurrent.*;
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

        work.invokeAll(callableList).stream().map(future->{
            try {
                return future.get();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
        }).forEach(System.out::println);

//        futureList.forEach(future->{
//            System.out.println(future.get());
//        });
    }
}
