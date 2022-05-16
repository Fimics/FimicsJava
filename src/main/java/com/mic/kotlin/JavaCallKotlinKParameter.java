package com.mic.kotlin;

import com.mic.p13_kotlinjava.MyClass5;

public class JavaCallKotlinKParameter {
    public static void main(String[] args) {
        MyClass5 myClass4 = new MyClass5();

        myClass4.method("hello world");
         //此外不能传null
//        myClass4.method(null);
    }
}
