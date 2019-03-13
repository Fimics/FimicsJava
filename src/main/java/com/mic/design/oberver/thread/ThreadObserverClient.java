package com.mic.design.oberver.thread;

import java.util.Arrays;

public class ThreadObserverClient {

    public static void main(String[] args) {

        ThreadObserver observer = new ThreadObserver();
        observer.concurrentQuery(Arrays.asList("A","B","C","D","E"));

    }
}
