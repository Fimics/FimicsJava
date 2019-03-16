package com.mic.thread.design.threadcontext;

import java.util.stream.IntStream;

/**
 * 线程上下文 想想android context
 */
public class ThreadContextDemo {

    public static void main(String[] args) {

        IntStream.range(1,5)
                .forEach(i->new Thread(new ExecutionTask()).start());
    }
}
