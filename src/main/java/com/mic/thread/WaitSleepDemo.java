package com.mic.thread;


/**
 * 生产者消费者
 * wait()与sleep()
 * 1.wait()是object方法sleep()是线程的方法
 * 2.wait()不持有对象锁，sleep()持有对象锁
 * 3.使用wait(),必须依赖 monitor
 * 4.wait()不会自动唤醒。。wait(1000)时间到了会自动唤醒
 */
public class WaitSleepDemo {

    private int index = 0;
    private static final Object lock = new Object();
    private static volatile boolean hasP = false;

    public static void main(String[] args) {

        WaitSleepDemo demo = new WaitSleepDemo();
        demo.start();
    }


    private void start() {

        for (int i = 0; i < 3; i++) {
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
                    lock.wait(1000); //时间到了自动唤醒
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
                    //Thread.sleep(1000);
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
