package com.mic.java8.function;

public interface DefaultMethodSecond {

    public void stop();

    default void play(){
        System.out.println("playing..on..");
    }
}
