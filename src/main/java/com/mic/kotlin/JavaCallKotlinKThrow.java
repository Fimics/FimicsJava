package com.mic.kotlin;

import com.mic.p13_kotlinjava.MyClass4;

import java.io.FileNotFoundException;
public class JavaCallKotlinKThrow {
    public static void main(String[] args) {
        MyClass4 myClass3 = new MyClass4();

        try {
            myClass3.method();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        System.out.println("hello world");
    }
}
