package com.mic.thread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo {


    private static final ReentrantLock lock = new ReentrantLock();
    private final static Condition condition = lock.newCondition();

    private static int data = 0;
    private static volatile boolean isUsed = false;

    private static void buildData() {
        try {
            lock.lock(); // == synchronized
            while (!isUsed) {
                condition.await(); //monitor.wait();
            }

            data++;
            System.out.println("build  data = " + data);
            TimeUnit.SECONDS.sleep(2);
            isUsed = false;
            condition.signal(); // notify
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    private static void useData() {

        try {
            lock.lock();
            while (isUsed) {
                condition.await();
            }

            System.out.println("use data = " + data);
            isUsed = true;
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            while (true) {
                buildData();
            }
        }).start();
        new Thread(() -> {
            while (true) {
                useData();
            }
        }).start();
    }
}
