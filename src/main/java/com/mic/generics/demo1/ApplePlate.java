package com.mic.generics.demo1;

public class ApplePlate implements IPlate<Apple> {
    @Override
    public void set(Apple apple) {

    }

    @Override
    public Apple get() {
        return null;
    }
}

//class Test{
//    static class A{}
//    static class B{}
//
//    static interface C{}
//    static interface D{}
//
//    static class E<T extends C,A ,B>{}
//}