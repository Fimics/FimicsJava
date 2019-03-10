package com.mic.thread;


/**
 *
 */
public class ThreadException implements Thread.UncaughtExceptionHandler {

    private final static int A=10;
    private final static int B=0;

    public static void main(String[] args) {

        ThreadException exception = new ThreadException();
        exception.byZero();

    }


    private void byZero(){

        Thread t = new Thread(()->{
            try {
                Thread.sleep(2000);
                int c =A/B;
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        });
        t.setUncaughtExceptionHandler(this);
        t.start();
    }


    @Override
    public void uncaughtException(Thread t, Throwable e) {
       System.out.println(e.getMessage());
        System.out.println(t.getName());
    }
}
