package com.mic.thread.concurrent;

import java.util.Random;
import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

/**
 * 交换机，两个线程之间交换数据
 */
public class ExchangerDemo {

    private static Random random = new Random(System.currentTimeMillis());
    static final Exchanger<String> exchanger = new Exchanger<>();
    static final Exchanger<Object> exchanger2 = new Exchanger<>();
    static final Exchanger<Integer> exchanger3 = new Exchanger<>();

    public static void main(String[] args) {


        Stream.of("A", "B", "C", "D", "F", "E").forEach(s -> {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " start");
                try {
                    //result 另一个线程返回来的值
                    //String result = exchanger.exchange("I am come form:" + Thread.currentThread().getName());
                    String result = exchanger.exchange("I am come form:" + Thread.currentThread().getName(),10, TimeUnit.SECONDS );
                    System.out.println(Thread.currentThread().getName() + " get value " + result );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " end");

            }, s).start();
        });

        Object obj = new Object();

        Stream.of("AA", "BB").forEach(s -> {
            new Thread(() -> {

                System.out.println(Thread.currentThread().getName() + " send "+obj);
                try {
                    Object result = exchanger2.exchange(obj);
                    System.out.println(Thread.currentThread().getName() + " received obj " + result );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " end");

            }, s).start();
        });


        AtomicReference<Integer> value = new AtomicReference<Integer>(1);

        Stream.of("AAA", "BBB").forEach(s -> {
            new Thread(() -> {



                while (true){
                    try {
                        System.out.println(Thread.currentThread().getName()+" send "+value.get());
                        value.set(value.get()+1);
                        value.set(exchanger3.exchange(value.get()));
                        System.out.println(Thread.currentThread().getName()+" received "+value.get());
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }, s).start();
        });

    }
}
