package com.mic.jcore.clzload;

import java.util.Arrays;

public class BootClassLoaderTest {

    public static void main(String[] args){
        Arrays.stream(System.getProperty("sun.boot.class.path").split(":")).forEach(s -> System.out.println(s));
        System.out.println("--------------------");
        Arrays.stream(System.getProperty("java.ext.dirs").split(":")).forEach(s -> System.out.println(s));

        System.out.println(new BootClassLoaderTest().getClass().getClassLoader());
        System.out.println(new BootClassLoaderTest().getClass().getClassLoader().getParent());
        System.out.println(new BootClassLoaderTest().getClass().getClassLoader().getParent().getParent());


        System.out.println("--------------------");
        Class<?> clazz = null;
        try {
            clazz = Class.forName("java.lang.String");
            System.out.println(clazz.getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(clazz);
    }
}
