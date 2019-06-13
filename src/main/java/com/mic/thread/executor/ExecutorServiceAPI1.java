package com.mic.thread.executor;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ExecutorServiceAPI1 {


    /**
     * Creates a new {@code ThreadPoolExecutor} with the given initial
     * parameters.
     *
     * @param corePoolSize the number of threads to keep in the pool, even
     *        if they are idle, unless {@code allowCoreThreadTimeOut} is set
     * @param maximumPoolSize the maximum number of threads to allow in the
     *        pool
     * @param keepAliveTime when the number of threads is greater than
     *        the core, this is the maximum time that excess idle threads
     *        will wait for new tasks before terminating.
     * @param unit the time unit for the {@code keepAliveTime} argument
     * @param workQueue the queue to use for holding tasks before they are
     *        executed.  This queue will hold only the {@code Runnable}
     *        tasks submitted by the {@code execute} method.
     * @param threadFactory the factory to use when the executor
     *        creates a new thread
     * @param handler the handler to use when execution is blocked
     *        because the thread bounds and queue capacities are reached
     * @throws IllegalArgumentException if one of the following holds:<br>
     *         {@code corePoolSize < 0}<br>
     *         {@code keepAliveTime < 0}<br>
     *         {@code maximumPoolSize <= 0}<br>
     *         {@code maximumPoolSize < corePoolSize}
     * @throws NullPointerException if {@code workQueue}
     *         or {@code threadFactory} or {@code handler} is null
     */

    private static final Random random = new Random();
    public static void main(String[] args) {
        testThreadTimeOut();
    }

    private static void testThreadTimeOut(){
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        executor.setKeepAliveTime(1,TimeUnit.SECONDS);
        //等待核心任务执行完，而且KeepAliveTIme到了core线程会结束
        executor.allowCoreThreadTimeOut(true);

        IntStream.range(0,5).boxed().forEach(i->{
            executor.execute(()->{
                try {
                    TimeUnit.SECONDS.sleep(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                System.out.println("-------------start "+i+"----------------");
//                System.out.println("PoolSize -> "+executor.getPoolSize());
//                System.out.println("QueueSize -> "+executor.getQueue().size());
//                System.out.println("TaskCount -> "+executor.getTaskCount());
//                System.out.println("ActiveCount -> "+executor.getActiveCount());
//                System.out.println("MaximumPoolSize -> "+executor.getMaximumPoolSize());
//                System.out.println("CorePoolSize -> "+executor.getCorePoolSize());
//                System.out.println("---------------end  "+i+"--------------------");
            });
        });

        /**
         * 正在执行的task是不能移除的，移除的是队列里的task
         */
        executor.remove(new Runnable() {
            @Override
            public void run() {

            }
        });

        executor.prestartCoreThread();

    }
}
