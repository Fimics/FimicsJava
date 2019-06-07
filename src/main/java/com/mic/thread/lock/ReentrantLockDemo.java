package com.mic.thread.lock;


import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class ReentrantLockDemo {

    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {

        IntStream.range(1,2).forEach(i->{
            new Thread(()->{
                needLock();
            },""+i).start();
        });

    }


    private static void needLock() {
        try {
            //lock.lock();
            boolean hasLock =lock.tryLock();
            System.out.println(lock.getHoldCount());// waiting queue
            System.out.println(lock.hasQueuedThread(Thread.currentThread()));
            if(!hasLock){
                return;
            }
            Optional.of("The thread -"+Thread.currentThread().getName()
                    +" get lock and will do working...").ifPresent(System.out::println);

            TimeUnit.SECONDS.sleep(10);
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            Optional.of("The thread -"+Thread.currentThread().getName()
                    +" release the lock...").ifPresent(System.out::println);
            lock.unlock();

        }

    }
}
