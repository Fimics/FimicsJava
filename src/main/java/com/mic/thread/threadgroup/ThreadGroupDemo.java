package com.mic.thread.threadgroup;

public class ThreadGroupDemo {

    public static void main(String[] args) {
        ThreadGroup tg1 = new ThreadGroup("TG1");

        Thread t1 = new Thread(tg1,"t1"){
            @Override
            public void run() {

                System.out.println(getThreadGroup().getName());
                System.out.println(getThreadGroup().getMaxPriority());
                System.out.println(getThreadGroup().getParent().activeCount());
            }
        };

        t1.start();

        ThreadGroup tg2 = new ThreadGroup("TG2");

        Thread t2 = new Thread(tg2,"t2"){
            @Override
            public void run() {

                System.out.println(tg1.getName());
            }
        };

        t2.start();


    }
}
