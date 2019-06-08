package com.mic.thread.lock;

import java.util.ArrayList;
import java.util.concurrent.locks.StampedLock;

public class StampedLockDemo {

    /**
     * ReentrantLook（）  VS synchronized
     * 1. synchronized 只是一个关键字，可定制性差 ，synch也叫权重锁
     * 2. 显示锁，也叫自旋锁
     * <p>
     * R  W  X
     * W  W  X
     * W  R  X
     * R  R  O
     * <p>
     * 100 threads
     * 99 threads need read lock
     * 1  thread need write lock
     *
     * @param args
     */

    private static final StampedLock lock = new StampedLock();
    private static ArrayList<Long> datas = new ArrayList<>();

    public static void main(String[] args) {

        new Thread(()->{ while (true){ write();}}).start();
        new Thread(()->{while (true){read();}}).start();

    }


    private static void write(){

        long stamp = -1;

        try {
            stamp = lock.writeLock();
            datas.add(System.currentTimeMillis());
        }finally {
            lock.unlockWrite(stamp);
        }

    }
    private static void read() {

         long stamp =lock.tryOptimisticRead(); //乐观的去读
         if(lock.validate(stamp)){
             //TODO
         }

//        long stamped = -1;
//        try {
//            stamped = lock.readLock();
//            datas.stream().map(l -> String.valueOf(l)).forEach(s -> System.out.println("r- " + s));
//        } finally {
//            lock.unlockRead(stamped);
//        }
    }
}
