package com.mic.thread.executor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class ExecutorServiceAPI {

    public static void main(String[] args) {
        //isShutdown();
        //isTerminated();
        //executeRunnableError();
        executeRunnableTask();
    }

    private static void isShutdown() {
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(service.isShutdown());
        service.shutdown();
        System.out.println(service.isShutdown());
        /**
         * shutdown之后不能再执行task
         */
        service.execute(() -> {
        });
    }

    /**
     * {@link ExecutorService#isTerminated()}
     * {@link ThreadPoolExecutor#isTerminating()}
     */
    private static void isTerminated() {
        ExecutorService service = Executors.newFixedThreadPool(1);
        service.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        service.shutdown();
        System.out.println(service.isShutdown());
        System.out.println(service.isTerminated());
        System.out.println(((ThreadPoolExecutor) service).isTerminating());
    }


    private static void executeRunnableError() {
        ExecutorService service = Executors.newFixedThreadPool(10, new MyThreadFactory());
        service.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        IntStream.rangeClosed(0, 10).forEach(i -> {
            service.execute(() -> {
                System.out.println(Thread.currentThread().getName() + 1 / 0);
            });
        });
        service.shutdown();
    }

    private static class MyThreadFactory implements ThreadFactory {

        private final static AtomicInteger seq = new AtomicInteger();

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setName("My-Thread-" + seq.getAndIncrement());
            thread.setUncaughtExceptionHandler(((t, e) -> {
                System.out.println("The thread " + t.getName() + " execute failed.");
                e.printStackTrace();
                System.out.println("-------------------------------");
            }));
            return thread;
        }
    }

    private static void executeRunnableTask() {
        ExecutorService service = Executors.newFixedThreadPool(10,new MyThreadFactory());
        IntStream.rangeClosed(0,10).forEach(i->{
            service.execute(new MyTask(i) {
                @Override
                protected void error(Exception e) {
                    System.out.println("error "+i);
                }

                @Override
                protected void doExecute() {
                    System.out.println("doExecute "+i);
                    if(i%5==0){
                        int x = i/0;
                    }
                }

                @Override
                protected void doInit() {
                    System.out.println("doInit "+i);
                }

                @Override
                protected void done() {
                    System.out.println("done "+i);
                }
            });
        });
        service.shutdown();
    }

    private abstract static class MyTask implements Runnable{
        private final int no;

        public MyTask(int no) {
            this.no = no;
        }

        @Override
        public void run() {
            try {
                this.doInit();
                this.doExecute();
                this.done();
            }catch (Exception e){
                this.error(e);
            }
        }

        protected abstract void error(Exception e);

        protected abstract void doExecute();

        protected abstract void doInit();

        protected abstract void done();
    }
}
