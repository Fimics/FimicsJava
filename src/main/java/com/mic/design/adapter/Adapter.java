package com.mic.design.adapter;

/**
 * Created by lipengju on 2018/5/26.
 * 1.对象适配器
 * 2.类适配器，通过继承实现.
 */
public class Adapter implements Target {

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void sampleOperation1() {
        this.adaptee.sampleOperation1();
    }

    @Override
    public void sampleOperation2() {
         System.out.println("sampleOperation2...");
    }
}
