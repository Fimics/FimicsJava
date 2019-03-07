package com.mic.thread;


public class ThreadGroupDemo {

    public static void main(String[] args) {

        ThreadGroup group =Thread.currentThread().getThreadGroup();
        System.out.print(group.activeCount());
        System.out.print(group);

        System.out.print(group.activeCount());

    }
}
