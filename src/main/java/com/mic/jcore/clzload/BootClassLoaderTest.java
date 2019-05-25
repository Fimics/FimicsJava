package com.mic.jcore.clzload;

import java.util.Arrays;

public class BootClassLoader {

    public static void main(String[] args) {
        Arrays.stream(System.getProperty("sun.boot.class.path").split(":")).forEach(s -> System.out.println(s));
        System.out.println("--------------------");
        Arrays.stream(System.getProperty("java.ext.dirs").split(":")).forEach(s -> System.out.println(s));

        System.out.println(new BootClassLoader().getClass().getClassLoader());
        System.out.println(new BootClassLoader().getClass().getClassLoader().getParent());
        System.out.println(new BootClassLoader().getClass().getClassLoader().getParent().getParent());
    }
}
