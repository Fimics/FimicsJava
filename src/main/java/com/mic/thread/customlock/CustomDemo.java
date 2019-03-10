package com.mic.thread.customlock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class CustomDemo {

    private static final XLock lock = new XLock();
    private static List<Thread> pool = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {


        CustomDemo demo = new CustomDemo();

        Stream.of("T1", "T2", "T3", "T4", "T5")
                .map(name->new Thread(()->{

                    try {
                        lock.lock();
                        demo.work();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        lock.unlock();
                    }

                },name))
                .forEach(thread -> {
                    thread.start();
                    pool.add(thread);
                });


        pool.stream().forEach(t-> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        lock.lock();
        System.out.println(Thread.currentThread().getName()+"  working ...");
        Thread.sleep(3000);
        lock.unlock();


    }

    private  void work() throws InterruptedException {
        Optional.of(Thread.currentThread().getName() + " is working ....").ifPresent(System.out::println);
        Thread.sleep(2000);
    }
}
