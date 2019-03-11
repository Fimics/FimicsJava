package com.mic.thread;

/**
 * 1. wait到是阻塞在哪了？放在waitset中，是个虚的概念，JVM去实现
 * 2. 所有的对象都会有一个waitset 用来存放存放调用了该对象wait方法之后进入block状态线程
 * 3. 线程 notify之后不一定立刻执行
 * 4. 线程从waitset中唤醒的顺序，不一定是FIFO的顺序
 * 5. 当唤醒时 会抢锁，因为有地址回复会接着wait()的代码执行
 */
public class WaitSetDemo {

    private static final Object lock = new Object();

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                work();
            }
        }.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (lock) {
            lock.notify();
        }

        /**
         IntStream.rangeClosed(1,10).forEach(i->new Thread(String.valueOf(i)){
        @Override public void run() {
        synchronized (lock) {
        try {
        Optional.of(Thread.currentThread().getName() + " will come to wait set ").ifPresent(System.out::println);
        lock.wait();
        Optional.of(Thread.currentThread().getName() + " will leave to wait set ").ifPresent(System.out::println);

        } catch(InterruptedException e){
        e.printStackTrace();
        }
        }
        }
        }.start());


         IntStream.rangeClosed(1,10).forEach(i->{
         synchronized (lock){
         lock.notifyAll();
         try {
         Thread.sleep(1000);
         } catch (InterruptedException e) {
         e.printStackTrace();
         }
         }
         });
         */
    }

    private static void work() {
        synchronized (lock) {
            System.out.println("begin...");
            try {
                System.out.println("Thread will coming...");
                lock.wait();//当唤醒时 会抢锁，因为有地址回复会接着wait()的代码执行
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Thread will out");
        }
    }
}
