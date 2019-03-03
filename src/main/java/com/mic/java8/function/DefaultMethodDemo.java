package com.mic.java8.function;

public class DefaultMethodDemo  implements DefaultMethod,DefaultMethodSecond{

    public static void main(String[] args) {
        DefaultMethodDemo demo = new DefaultMethodDemo();
        demo.play();
    }

    @Override
    public void stop() {
    }

    @Override
    public void play() {
        //如果实现的两个接口有同名的default 方法，编译器要求用户自己实现,也可以通super让用户自己去选
        System.out.println("playing defaultMethod- defaultMethodSecond");
        DefaultMethod.super.play();
    }
}
