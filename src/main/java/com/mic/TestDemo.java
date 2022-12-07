package com.mic;

public class TestDemo {

    int a ;
    int b;

    public static void main(String[] args) {
        TestDemo d = new TestDemo();
        d.a=10;
        TestDemo e = d;
        e.a=20;
        System.out.println("d.a=="+d.a);
    }
}
