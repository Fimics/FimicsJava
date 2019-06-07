package com.mic.thread.lock;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWtiteLockDemo {

    private static final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);
    private static final Lock readLock  = readWriteLock.readLock();
    private static final Lock writeLock = readWriteLock.writeLock();
    private static ArrayList<Long> datas = new ArrayList<>();

    public static void main(String[] args) {

        new Thread(()->{write();}).start();
        read();
    }


    private static void write() {

        for(;;){
            try {
                writeLock.lock();
                datas.add(System.currentTimeMillis());
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
               writeLock.unlock();
            }
        }
    }

    private static void read() {

        while (true) {
            readLock.lock();
            System.out.println("datas size "+datas.size());
//            datas.forEach(l -> {
//                System.out.println(l);
//            });
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                readLock.unlock();
            }
        }
    }
}
