package com.mic.thread.design.twophase;

import java.util.Random;

public class CounterIncrement extends Thread {

    private volatile boolean terminated = false;

    private int counter = 0;

    private Random random = new Random(System.currentTimeMillis());

    @Override
    public void run() {
        try {
            while (!terminated) {
                System.out.println(Thread.currentThread().getName() + counter++);
                try {
                    sleep(random.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            this.clean();
        }
    }


    private void clean() {
        System.out.println(Thread.currentThread().getName()+"--> clean..."+"  counter -->"+counter);
    }

    public void close() {
        this.terminated = true;
        this.interrupt();
    }
}
