package com.mic.thread;

public class SynchronizedDemo {

    private  int index;
    private   int MAX = 1000;

    private final Object lock = new Object();

    public static void main(String[] args) {

        SynchronizedDemo demo = new SynchronizedDemo();
        demo.ticketNum();


    }

    private void ticketNum() {
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new Ticket());
            t.start();
        }
    }

    private class Ticket implements Runnable {

        @Override
        public void run() {

            while (true) {

                synchronized (lock) {
                    if (index > MAX) {
                        break;
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    /**
                     * index ++
                     * 1.get Filed index
                     * 2.index =index+1
                     * 3.put filed index = index
                     */

                    System.out.println(Thread.currentThread().getName() + "-------this thread index : " + (index++));
                }
            }
        }
    }

}
