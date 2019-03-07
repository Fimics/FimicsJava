package com.mic.thread;

public class InterruptDemo {



    public static void main(String[] args) {


        Thread t = new Thread(new Runnable() {

            private boolean isRun = true;
            @Override
            public void run() {
                while (isRun){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        System.out.println("InterruptedException");
                        isRun = false;
                    }

                    System.out.println("------");

                    synchronized (InterruptDemo.class){
                        try {
                            wait(100);
                        } catch (InterruptedException e) {
                            System.out.println("Wait()");
                            e.printStackTrace();

                        }
                    }


                }
            }
        });

        t.start();

        System.out.println(t.isInterrupted());
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("join");
        }
        t.interrupt();
        System.out.println(t.isInterrupted());
    }

}
