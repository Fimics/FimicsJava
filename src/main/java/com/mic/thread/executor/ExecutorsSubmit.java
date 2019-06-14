package com.mic.thread.executor;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ExecutorsSubmit {

    public static void main(String[] args) throws InterruptedException {
         testInvokeAny();
    }

    private static void testInvokeAny() throws InterruptedException {
        ExecutorService  service = Executors.newFixedThreadPool(10);
        List<Callable<Integer>> callables =IntStream.range(1,5).boxed().map(i->(Callable<Integer>)()->{
            try {
                TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return i;
        }).collect(Collectors.toList());

        List<Future<Integer>> value = service.invokeAll(callables);
        System.out.println("=============finished==============");
        value.forEach(integerFuture -> {
            try {
                System.out.println(integerFuture.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

    }
}
