package com.mic.thread.atomic;

import java.util.stream.IntStream;

public class AtomicLockClient {

    private static AtomicTryLock lock = new AtomicTryLock();

    public static void main(String[] args) {

        IntStream.range(1, 5).forEach(i -> new Thread(() -> {
            try {
                doSomething2();
            } catch (AtomicTryLockException e) {
                e.printStackTrace();
                lock.unlock();
            }
        }).start());
    }

    private static void doSomething() throws InterruptedException {
        synchronized (AtomicLockClient.class) {
            System.out.println(Thread.currentThread().getName() + " get the lock");
            Thread.sleep(1000000);
        }
    }

    private static void doSomething2() throws AtomicTryLockException {

        try {
            lock.tryLock();
            System.out.println(Thread.currentThread().getName() + " get the lock");
            Thread.sleep(1000);
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}
