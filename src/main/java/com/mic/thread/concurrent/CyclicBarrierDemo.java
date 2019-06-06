package com.mic.thread.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class CyclicBarrierDemo {

    private static final  CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
        @Override
        public void run() {
            //所有线程完成工作，这里回调
            System.out.println("all finished...");
            System.out.println(cyclicBarrier.getNumberWaiting());
            //cyclicBarrier.reset();
        }
    });

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {

        Stream.of(1,2,3,4,5).forEach(integer -> {
            new Thread(() ->{

                System.out.println(Thread.currentThread().getName()+"working...");
                try {
                    TimeUnit.SECONDS.sleep(integer*5);
                    System.out.println(Thread.currentThread().getName()+"finished too.");
                    //每个线程完成任务在这里等待其他线程完成工作
                    System.out.println(cyclicBarrier.getNumberWaiting());
                    System.out.println(cyclicBarrier.getParties());
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }


            }).start();
        });


        System.out.println(cyclicBarrier.getNumberWaiting());
        System.out.println(cyclicBarrier.getParties());

    }
}
