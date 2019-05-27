package com.mic.thread.atomic;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIngegerTest {

    /**
     * volatile 的作用
     * 1.保证可见性
     * 2.保证顺序性，禁止内存重排序
     * 3.不能保证原子性 no atomic //Atomic有以上几个作用
     */
    //private static volatile   int value = 0;

    private static  AtomicInteger value = new AtomicInteger(0);

    private static final int DATA_COUNT = 500;

    private static Set<Integer> set = Collections.synchronizedSet(new HashSet<>());

    public static void main(String[] args) throws InterruptedException {

        VolatileRunnable runnable = new VolatileRunnable();
        VolatileRunnable runnable1 = new VolatileRunnable();
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable1);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("set size -->" + set.size());
        missDatas();

    }

    private static void missDatas() {
        Set<Integer> tempSet = new HashSet<>();
        for (int i=0;i<=DATA_COUNT;i++) {
            tempSet.add(i);
        }

        tempSet.removeAll(set);
        System.out.println(tempSet);
    }

    private static class VolatileRunnable implements Runnable {
        @Override
        public void run() {
            Integer x ;
            while ((x =value.getAndIncrement()) < DATA_COUNT) {
                set.add(x);
                System.out.println(Thread.currentThread().getName() + " : " + value.get());

                /**
                 * value +1 原理
                 * 1. get value from main memory to local memory
                 * 2. add 1=> value
                 * 3.fulush to main memory
                 */
            }
        }
    }
}
