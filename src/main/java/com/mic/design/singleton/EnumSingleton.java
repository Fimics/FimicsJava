package com.mic.design.singleton;

/**
 * Created by lipengju on 2018/5/25.
 * enum singleton
 * 优点:写法简单/线程安全
 */
public enum EnumSingleton {

    INSTANCE;

    //不能保证线程安全
    public void doSomething(){

    }


    public synchronized void doPoll(){

    }
}
