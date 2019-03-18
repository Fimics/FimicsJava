package com.mic.thread.design.workerthread;

import java.util.Random;

public class WorkerThread extends Thread {

    private final Channel channel;
    private final static Random random = new Random(System.currentTimeMillis());

    public WorkerThread(String s, Channel channel) {
        super(s);
        this.channel=channel;
    }

    @Override
    public void run() {
        while (true){
            channel.take().execute();
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
