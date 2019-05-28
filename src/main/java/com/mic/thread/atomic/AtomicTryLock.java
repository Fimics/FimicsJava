package com.mic.thread.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTryLock {

    private final AtomicInteger value = new AtomicInteger(0);
    private Thread lockedThread;

    public void tryLock() throws AtomicTryLockException{
       boolean success = value.compareAndSet(0,1);
       if(!success){
           throw new AtomicTryLockException(Thread.currentThread().getName()+" get the locak failed");
       }else{
           lockedThread=Thread.currentThread();
       }
    }

    public void unlock(){
        if(0==value.get()) return;

        if(lockedThread==Thread.currentThread()){
            value.compareAndSet(1,0);
        }

    }
}
