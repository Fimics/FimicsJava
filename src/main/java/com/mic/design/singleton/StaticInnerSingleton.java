package com.mic.design.singleton;

/**
 * Created by lipengju on 2018/5/25.
 * 静态内部类是比较好的写法
 *
 * 优点:
 * 1.JVM本身机制保证了线程安全
 * 2.没有性能缺陷
 *
 * 同步控制
 * static 保证数在内存中是独一份的 final 不能被修改，所以也是线程安全的
 *
 */
public class StaticInnerSingleton {

    private  StaticInnerSingleton(){}

    public static StaticInnerSingleton getInstance(){
        return  SingletonHolder.instance;
    }

    /**
     * 1.只要不使用内部类，jvm就不会创建它，同时就不会创建instance实例，保证了延迟加载
     * 2.static final 由JVM保证了线程安全
     */
    private static class SingletonHolder{
        private static final StaticInnerSingleton instance = new StaticInnerSingleton();
    }
}
