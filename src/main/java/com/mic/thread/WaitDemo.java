package com.mic.thread;


/**
 * 生产者消费者
 */
public class WaitDemo {

    private int index = 0;
    private static final Object lock = new Object();
    private static volatile boolean hasP = false;

    public static void main(String[] args) {

        WaitDemo demo = new WaitDemo();
        demo.start();
    }


    private void start() {

        for (int i = 0; i < 2; i++) {
            Thread p = new Thread(() -> {
                while (true) {
                    produce();
                }
            });
            Thread c = new Thread(() -> {
                while (true) {
                    consume();
                }
            });
            p.start();
            c.start();
        }
    }

    /**
     * 消费者
     */
    private void consume() {
        synchronized (lock) {

            if (hasP) {
                System.out.println(Thread.currentThread().getName() + " : cc---> " + index);
                hasP = false;
                lock.notify();
            } else {
                try {
                    lock.wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    /**
     * 生产者
     */
    private void produce() {

        synchronized (lock) {

            if (hasP) {
                try {
                    // if has a produce just notfiy other consume it
                    lock.wait(1000);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                index++;
                System.out.println(Thread.currentThread().getName() + " pp-----> " + index);
                hasP = true;
                lock.notify();
            }

        }
    }


}
