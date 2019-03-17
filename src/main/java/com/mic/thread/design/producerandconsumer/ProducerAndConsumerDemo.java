package com.mic.thread.design.producerandconsumer;

import java.util.stream.IntStream;

public class ProducerAndConsumerDemo {
    public static void main(String[] args) {

        final MessageQueue queue = new MessageQueue();

        IntStream.range(1, 5).forEach(i -> {
                  new ProducerThread(queue,i).start();
                  new ConsumerThread(queue,i).start();
                }
        );
    }
}
