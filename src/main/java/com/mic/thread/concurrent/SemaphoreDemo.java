package com.mic.thread.concurrent;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class SemaphoreDemo {


    public static void main(String[] args) {

        final SemaphoreLock lock = new SemaphoreLock();

        Stream.of("A","B","C","D","E","F","G","H","J","K","L","M","N").forEach(s -> {
            new Thread(()->{
                try {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName()+" get the #SemaphoreLock.");
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                    System.out.println(Thread.currentThread().getName()+" release the #SemaphoreLock.");
                }
            },s).start();
        });

    }


    private static class SemaphoreLock{

        private final Semaphore semaphore = new Semaphore(3);

        public void lock() throws InterruptedException {
            //申请一个许可证，事实上是没有一个真正的许可证，只是使用了一个传进来的number
            //semaphore.acquire();
            semaphore.acquire(1);
            System.out.println("AP->"+semaphore.availablePermits());
            System.out.println("QL->"+semaphore.getQueueLength());//当前有哪些线程blocked

            //semaphore.drainPermits()//获取到所有的许可证
            //semaphore.isFair(); 是否公平的
        }

        public void unlock(){
           // semaphore.release();
            semaphore.release(1);
        }
    }
}
