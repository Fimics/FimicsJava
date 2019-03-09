package com.mic.thread;

public class DeadLockDemo {


    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        DeadLockDemo demo = new DeadLockDemo();
        demo.testDeadLock();

    }


    private void testDeadLock(){
       Thread t1 = new Thread(()-> push());
       Thread t2 = new Thread(()->pop());
       t1.start();
       t2.start();
    }




    private void pop(){
        synchronized (lock1){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock2){
               System.out.println("pop----");
           }
        }
    }


    private void push(){
        synchronized (lock2){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock1){
               System.out.println("push---");
           }
        }
    }



}
