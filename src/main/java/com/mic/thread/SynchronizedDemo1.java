package com.mic.thread;

import java.util.Optional;

public class SynchronizedDemo1 {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            work();
        });

        t1.start();

        Thread.sleep(1000);

        Thread t2 = new Thread(()->{
            work();
        });
        t2.start();
        t1.interrupt();
    }


    private synchronized static  void work(){
        while (true){
            Optional.of(Thread.currentThread().getName()+" running...").ifPresent(System.out::println);
        }
    }
}
