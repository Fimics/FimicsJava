package com.mic.thread.executor;

import java.util.concurrent.*;
import java.util.stream.IntStream;

public class ExecutorServiceAbortPolicy {

    /**
     * (int corePoolSize,
     * int maximumPoolSize,
     * long keepAliveTime,
     * TimeUnit unit,
     * BlockingQueue<Runnable> workQueue,
     * ThreadFactory threadFactory,
     * RejectedExecutionHandler handler)
     */

    public static void main(String[] args) throws InterruptedException {

        //testAbortPoicy();
        //testDiscardPolicy();
        //testCallerRunsPolicy();
        testDiscardOldestPolicy();
    }

    /**
     * 当提交的任务数大于coreSize+maxSise时抛出以下异常
     *java.util.concurrent.RejectedExecutionException:
     */
    private static void testAbortPoicy() throws InterruptedException {
        ExecutorService service = new ThreadPoolExecutor(1, 2, 30, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r);
            }
        },new ThreadPoolExecutor.AbortPolicy());

        IntStream.range(0,3).boxed().forEach(i -> {
            service.execute(()->{
                    System.out.println(Thread.currentThread().getName()+" testAbortPoicy workig ...");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });

        service.execute(()->{
            System.out.println("main thread working ...");
        });
        service.shutdown();
    }


    /**
     * 当提交的任务数大于coreSize+maxSise时,没有任何信息，建议不要用
     */
    private static void testDiscardPolicy() throws InterruptedException {
        ExecutorService service = new ThreadPoolExecutor(1, 2, 30, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r);
            }
        },new ThreadPoolExecutor.DiscardPolicy());

        IntStream.range(0,3).boxed().forEach(i -> {
            service.execute(()->{
                System.out.println(Thread.currentThread().getName()+" DiscardPolicy working ..");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });

        service.execute(()->{
            System.out.println("main thread working ...");
        });
        service.shutdown();
    }

    /**
     * 当提交的任务数大于coreSize+maxSise时,超出的线程4-2-1=1 谁提交谁去执行，而不是用threadpool执行
     * output---------------
     * Thread-0 testCallerRunsPolicy working ..
     * main testCallerRunsPolicy working ..
     * Thread-1 testCallerRunsPolicy working ..
     * Thread-0 testCallerRunsPolicy working ..
     * Thread-1 main thread working ...
     *
     */
    private static void testCallerRunsPolicy() throws InterruptedException {
        ExecutorService service = new ThreadPoolExecutor(1, 2, 30, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r);
            }
        },new ThreadPoolExecutor.CallerRunsPolicy());

        IntStream.range(0,4).boxed().forEach(i -> {
            service.execute(()->{
                System.out.println(Thread.currentThread().getName()+" testCallerRunsPolicy working ..");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });

        service.execute(()->{
            System.out.println(Thread.currentThread().getName()+" main thread working ...");
        });
        service.shutdown();
    }

    /**
     * 当提交的任务数大于coreSize+maxSise时,会把超出的提交丢弃，转而执行最新的提交
     */
    private static void testDiscardOldestPolicy() throws InterruptedException {
        ExecutorService service = new ThreadPoolExecutor(1, 2, 30, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r);
            }
        },new ThreadPoolExecutor.DiscardOldestPolicy());

        IntStream.range(0,8).boxed().forEach(i -> {
            service.execute(()->{
                System.out.println(Thread.currentThread().getName()+" testDiscardOldestPolicy  ..");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });

        service.execute(()->{
            System.out.println("main thread working ...");
        });
        service.shutdown();
    }
}
