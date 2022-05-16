package com.mic.kotlin;
import com.mic.p13_kotlinjava.MyClass2;
import com.mic.p13_kotlinjava.People1;
public class JavaCallKotlinKCompanion {
    public static void main(String[] args) {
        System.out.println(People1.Companion.getName());
        System.out.println(People1.age);

        MyClass2.Companion.test1();
        MyClass2.Companion.test2();

        MyClass2.test2();
    }
}
