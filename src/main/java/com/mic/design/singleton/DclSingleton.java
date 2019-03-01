package com.mic.design.singleton;

/**
 * Created by lipengju on 2018/5/25.
 * 双重检查锁机制
 * 缺点: JVM的即时编译器中存在指令重排序的优化
 */
public class DclSingleton {

    //volatile 变量可见性，保证内存中不存在副本，
    private static volatile DclSingleton instance=null;

    private DclSingleton(){}

    public void doSomething(){
        System.out.println("do something");
    }

    public static DclSingleton getInstance(){
        //避免不必要的同步
        if(null==instance){
            synchronized (DclSingleton.class){
                if (null==instance){
                    /**这句不是原子操作 ，存在指令重排序优化
                     * 1.给 instance分配内存
                     * 2.调用DclSingleton构造方法初化
                     * 3.创建好的对象指像instance分配的内存空间
                     */
                    instance= new DclSingleton();
                }
            }
        }

        return instance;
    }


}


