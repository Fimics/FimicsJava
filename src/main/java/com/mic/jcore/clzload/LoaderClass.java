package com.mic.jcore.clzload;

/**
 * 类的加载过程
 */
public class LoaderClass {

    public static void main(String[] args) {
        MyObject m1 = new MyObject();
        MyObject m2 = new MyObject();
        MyObject m3 = new MyObject();
        MyObject m4 = new MyObject();

        System.out.println(m1.getClass()==m2.getClass());

    }
}

