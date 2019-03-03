package com.mic.java8.function;

public interface DefaultMethod {

    public void stop();

    default void play(){
        System.out.println("playing..");
    }
}
