package com.mic.thread.executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ThreadPoolExecutorTask {

    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(10,20,30, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1),r -> {
                 Thread t = new Thread(r);
                 return t;
        },new ThreadPoolExecutor.AbortPolicy());


        IntStream.rangeClosed(0,20).boxed().forEach(i->{
            executorService.submit(()->{
                try {
                    TimeUnit.SECONDS.sleep(10);
                    System.out.println(Thread.currentThread().getName()+"[ "+i+" ] finish done.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });
    }
}
