package com.mic.thread.design.countdown;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

/**
 * countdown :等待所有线程执行完再去执行第二阶段的事情
 */
public class FCountDownDemo {

    private static final Random random = new Random(System.currentTimeMillis());
    private static FCountDown countDown = new FCountDown(5);// 5 和线程数据相等

    public static void main(String[] args) throws InterruptedException {

        //the first phase
        System.out.println("准备多线程处理任务...");
        IntStream.rangeClosed(1,5).forEach(i->{
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"执行中...");
                try {
                    Thread.sleep(random.nextInt(2000));
                    System.out.println(Thread.currentThread().getName()+"工作完成......");
                    countDown.down();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        });

        //the second phase
        countDown.await();
        System.out.println("多线程任务全部结束，开始执行第二阶段任务");
        System.out.println("--------------");
        System.out.println("FINISH...");



    }
}
