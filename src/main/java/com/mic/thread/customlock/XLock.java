package com.mic.thread.customlock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

public class XLock implements Lock {

    private static volatile boolean isLock;
    private Collection<Thread> blockedThreadCollection = new ArrayList<>();
    private Thread currentThread;

    public XLock() {
        this.isLock = false;
    }

    @Override
    public synchronized void lock() throws InterruptedException {
        while (isLock){
            blockedThreadCollection.add(Thread.currentThread());
            this.wait();
        }

        Optional.of(Thread.currentThread().getName() + " hava the lock monitor").ifPresent(System.out::println);
        blockedThreadCollection.remove(Thread.currentThread());
        this.isLock=true;
        this.currentThread = Thread.currentThread();
    }

    @Override
    public synchronized void lock(long mills) throws InterruptedException, TimeOutException {
         if(mills<=0) lock();

         long hasRemaining = mills;
         long endTime = System.currentTimeMillis()+mills;

         while (isLock){
             blockedThreadCollection.add(Thread.currentThread());
             this.wait();
         }

         if(System.currentTimeMillis()>endTime){
             unlock();
         }

    }

    @Override
    public synchronized void unlock() {
        if(Thread.currentThread()==currentThread && isLock){
            this.isLock=false;
            System.out.println(Thread.currentThread().getName()+" release the lock monitor");
            this.notifyAll();
        }
    }

    @Override
    public Collection<Thread> getBlockedThread() {
        return Collections.unmodifiableCollection(blockedThreadCollection);
    }

    @Override
    public int getBlockedSize() {
        return 0;
    }
}
