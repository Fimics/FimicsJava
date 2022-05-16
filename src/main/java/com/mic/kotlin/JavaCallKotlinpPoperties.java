package com.mic.kotlin;

import com.mic.p13_kotlinjava.MyClass;
import com.mic.p13_kotlinjava.MyClassKt;

class JavaCallKotlinpPoperties {


    public static void main(String[] args) {
        // 我们无法通过new关键字来创建Kotlin编辑器自动生成的以Kt结尾的类的实例
        // 因为在生成的字节码中没有不带参数的构造方法
//        HelloKotlin2Kt helloKotlin2Kt = new HelloKotlin2Kt();

        MyClass myClass = new MyClass();

        MyClassKt.setStr("welcome");
        System.out.println(MyClassKt.getStr());

        MyClassKt.test();
    }
}
