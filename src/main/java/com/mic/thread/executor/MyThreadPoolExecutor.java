package com.mic.thread.executor;

import java.util.concurrent.*;
import java.util.stream.IntStream;

public class MyThreadPoolExecutor extends ThreadPoolExecutor {

    private static final int CORE_SIZE = 1;
    private static final int MAX_SIZE = 2;
    private static final int QUEUQ_SIZE =1;
    static LinkedBlockingQueue blockingQueue = new LinkedBlockingQueue(QUEUQ_SIZE);

    public static void main(String[] args) {

        MyThreadPoolExecutor executor = buildPoolExecutor();
        IntStream.range(1,5).boxed().forEach(integer -> {
            executor.execute(()->{
                System.out.println(Thread.currentThread().getName()+" working...");
            });
        });

    }

    public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        System.out.println(t.getName()+" beforeExecute");
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        System.out.println("afterExecute");
    }

    private static MyThreadPoolExecutor buildPoolExecutor() {
        MyThreadPoolExecutor executorService = new MyThreadPoolExecutor(CORE_SIZE,MAX_SIZE, 30
                ,TimeUnit.SECONDS, blockingQueue,new ThreadPoolExecutorBuilder.MyThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        return executorService;
    }
}
