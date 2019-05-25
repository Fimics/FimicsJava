package com.mic.jcore.clzload;

public class MyObject {

    static {
        System.out.println("my object static block.");
    }

    public String hello(){
        return "hello world";
    }
}
