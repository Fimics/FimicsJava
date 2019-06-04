package com.mic.thread.concurrent;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class CountDownLatchDemo {

    private static Random random = new Random(System.currentTimeMillis());
    private static ExecutorService executor = Executors.newFixedThreadPool(2);
    private static CountDownLatch latch = new CountDownLatch(10);


    public static void main(String[] args) throws InterruptedException {

        int data[] = query().toArray();

        for (int i=0;i<data.length;i++){
            executor.execute(new SimpleRunnable(data,i,latch));
        }
//
//        executor.shutdown();
//        executor.awaitTermination(10, TimeUnit.SECONDS);


        latch.await();
        System.out.println("all of work finish don.1");
        executor.shutdownNow();

    }

    static class SimpleRunnable implements Runnable {

        private final int data[];
        private final int index;
        private final CountDownLatch latch;

        public SimpleRunnable(int[] data, int index, CountDownLatch latch) {
            this.data = data;
            this.index = index;
            this.latch = latch;
        }

        @Override
        public void run() {

            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int value = data[index];

            if (value % 2 == 0) {
                data[index] = value * 2;
            } else {
                data[index] = value * 100;
            }
            System.out.println(data[index]);
            System.out.println(Thread.currentThread().getName() + " done.");
            latch.countDown();
        }
    }

    private static IntStream query() {
        return IntStream.range(0, 10);
    }
}
