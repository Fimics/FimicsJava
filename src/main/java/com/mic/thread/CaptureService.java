package com.mic.thread;

import java.util.*;

/**
 * 数据采集
 */
public class CaptureService {

    private static LinkedList<Object> lock = new LinkedList();
    private static final int MAX_WORKER =5;

    public static void main(String[] args) {

        CaptureService service = new CaptureService();
        List<Thread> pool = new ArrayList<>();

        List<String> list =Arrays.asList("M1","M2","M3","M4","M5","M6","M7","M8","M9","M10");
        list.stream()
                .map(CaptureService::createThread)
                .forEach(t->{
                    t.start();
                    pool.add(t);
                });

        pool.stream().forEach(t->{
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Optional.of("all of capture work finished").ifPresent(System.out::println);
    }


    private static Thread createThread(String threadName){
        return new Thread(()->{

            Optional.of("the worker thread -> [" + Thread.currentThread().getName()+" ] will begin" ).ifPresent(System.out::println);

            synchronized (lock){
                while (lock.size()>MAX_WORKER){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                lock.add(new Object());
                System.out.println("the pool size -----------------------------------------------> "+lock.size());
            }

            Optional.of("the worker thread == [ "+Thread.currentThread().getName() +" ] is working...").ifPresent(System.out::println);

            try {
                Thread.sleep(10*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (lock){
                Optional.of("the worker thread <-- [ "+Thread.currentThread().getName()+ "] end capture data .").ifPresent(System.out::println);
                lock.removeFirst();
                lock.notifyAll();
            }


        },threadName);
    }
}
