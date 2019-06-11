package com.mic.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsFactory {

    /**
     * ThreadPoolExecutor(0, Integer.MAX_VALUE,
     *                  60L, TimeUnit.SECONDS,
     *                  new SynchronousQueue<Runnable>());
     */
    private static final ExecutorService cached = Executors.newCachedThreadPool();

    /**
     *  ThreadPoolExecutor(nThreads, nThreads,
     *                     0L, TimeUnit.MILLISECONDS,
     *                    new LinkedBlockingQueue<Runnable>());
     */
    ExecutorService fixed = Executors.newFixedThreadPool(5);

    /**
     * ew ThreadPoolExecutor(1, 1,
     *           0L, TimeUnit.MILLISECONDS,
     *           new LinkedBlockingQueue<Runnable>()));
     */
    ExecutorService single =Executors.newSingleThreadExecutor();

    /**
     *  jdk 1.8
     *  return new ForkJoinPool
     *             (Runtime.getRuntime().availableProcessors(),
     *              ForkJoinPool.defaultForkJoinWorkerThreadFactory,
     *              null, true);
     */
    ExecutorService workStealing = Executors.newWorkStealingPool();

    /**
     *  ScheduledThreadPoolExecutor(int corePoolSize) {
     *         super(corePoolSize, Integer.MAX_VALUE, 0, NANOSECONDS,
     *               new DelayedWorkQueue());
     */
    ExecutorService scheduled = Executors.newScheduledThreadPool(5);

    public static void main(String[] args) {

    }
}
