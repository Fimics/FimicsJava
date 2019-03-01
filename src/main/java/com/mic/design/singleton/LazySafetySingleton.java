package com.mic.design.singleton;

/**
 * Created by lipengju on 2018/5/24.
 * 懒汉线程安全模式：性能问题
 */
public class LazySafetySingleton {

    private static LazySafetySingleton instance;

    private LazySafetySingleton(){
        System.out.println("LazySingleton init...");
    }

    public static LazySafetySingleton getInstance(){

        synchronized (LazySafetySingleton.class) {
            if (null == instance) {
                instance = new LazySafetySingleton();
            }
        }

        return instance;
    }


    public static void createString(){
        System.out.println("createSting in LazySingleton");
    }


    public static void main(String args []){
        LazySafetySingleton.createString();
        //LazySingleton.getInstance();
    }


}
