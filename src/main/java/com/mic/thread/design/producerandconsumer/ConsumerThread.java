package com.mic.thread.design.producerandconsumer;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class ConsumerThread extends Thread {

    private final MessageQueue queue;

    private final static Random random = new Random(System.currentTimeMillis());

    private final static AtomicInteger counter = new AtomicInteger(0);

    public ConsumerThread(MessageQueue queue, int seq) {
        super("consumer-" + seq);
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Message message = queue.take();
                System.out.println(Thread.currentThread().getName() + " take -->" + message.getData());

                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
