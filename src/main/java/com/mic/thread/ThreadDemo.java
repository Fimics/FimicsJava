package com.mic.thread;

public class ThreadDemo {

    public static void main(String[] args) {
         createThread();
    }

    public static void createThread(){
        Thread thread = new Thread();
        thread.start();
        System.out.print(thread.getName());
    }
}
