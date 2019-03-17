package com.mic.thread.design.producerandconsumer;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class ProducerThread extends Thread {

    private final MessageQueue queue;

    private final static Random random = new Random(System.currentTimeMillis());

    private final static AtomicInteger counter = new AtomicInteger(0);

    public ProducerThread(MessageQueue queue, int seq) {
        super("producer-" + seq);
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            Message message = new Message("message-" + counter.getAndIncrement());

            try {
                queue.put(message);
                System.out.println(Thread.currentThread().getName() + " put -->" + message.getData());

                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
