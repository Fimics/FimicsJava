package com.mic.thread.atomic;

import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicBooleanClient {

    private static AtomicBoolean flag = new AtomicBoolean();
    public static void main(String[] args) throws InterruptedException {

        new Thread(()->{
            while (!flag.get()){
                try {
                    System.out.println("I am working ... ");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        Thread.sleep(5000);
        flag.set(true);
        System.out.println("I am finish ... ");
    }
}
