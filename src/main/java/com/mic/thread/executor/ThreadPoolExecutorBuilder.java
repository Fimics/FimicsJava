package com.mic.thread.executor;

import java.util.concurrent.*;

public class ThreadPoolExecutorBuilder {

    /**
     * Testing point.
     * <p>
     *   1. coreSize = 1 ,maxSize = 2 ,blockingQueue size= 1, what happen when submit 3 tasks？
     *   2. coreSize =1,maxSize = 2 ,blockingQueue size = 5, what happen when submit 7 tasks？
     *   3. coreSize= 1, maxSize =2, blockQueue size = 5, what happen when submit 8 tasks?
     *
     * </p>
     * int corePoolSize, 始终保持的线程数，如果提交的任务数小于coresize,会直接执行，当提交的任务数大于core时会把多于的任务
     *                   放到queue中，当提交的任务数>coresize+maxsize 会跑出异常
     *
     * int maximumPoolSize, 最大线程数
     * long keepAliveTime,  超过这个时间会回收线程，
     * TimeUnit unit,
     * BlockingQueue<Runnable> workQueue,
     * ThreadFactory threadFactory,
     * RejectedExecutionHandler handler
     */

    private static final int CORE_SIZE = 1;
    private static final int MAX_SIZE = 2;
    private static final int QUEUQ_SIZE =1;

    static LinkedBlockingQueue blockingQueue = new LinkedBlockingQueue(QUEUQ_SIZE);

    public static void main(String[] args) {
       ThreadPoolExecutor executorService = buildPoolExecutor();

       for (int i=0;i<4;i++){
           executorService.execute(new MyRunnable(i));
       }

       int activeCount = -1;
       int queueSize =-1;

       while (true){
           if(activeCount!=executorService.getActiveCount()|| queueSize!=executorService.getQueue().size()){
               System.out.println("getActiveCount "+executorService.getActiveCount());
               System.out.println("getCorePoolSize " +executorService.getCorePoolSize());
               System.out.println("getQueue size "+executorService.getQueue().size());
               System.out.println("getMaximumPoolSize"+executorService.getMaximumPoolSize());
               activeCount=executorService.getActiveCount();
               queueSize=executorService.getQueue().size();
               System.out.println("====================================");
           }
       }

    }


    private static ThreadPoolExecutor buildPoolExecutor() {
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(CORE_SIZE,MAX_SIZE, 30
                                      ,TimeUnit.SECONDS, blockingQueue,new MyThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

       return executorService;
    }

    static class MyThreadFactory implements ThreadFactory{

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r);
        }
    }

    static class  ExecutorHandler implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        }
    }

    static class MyRunnable implements Runnable{

        private int index;

        public MyRunnable(int index) {
            this.index = index;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName()+" index "+index);
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
