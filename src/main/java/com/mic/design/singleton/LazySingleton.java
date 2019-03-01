package com.mic.design.singleton;

/**
 * Created by lipengju on 2018/5/24.
 * 懒汉模式：多线程模式下，这种写法是失效的，也是错误的
 */
public class LazySingleton {

    private static LazySingleton instance;

    private LazySingleton(){
        System.out.println("LazySingleton init...");
    }

    public static LazySingleton getInstance(){
        if(null==instance){
            instance = new LazySingleton();
        }

        return instance;
    }


    public static void createString(){
        System.out.println("createSting in LazySingleton");
    }


    public static void main(String args []){
        LazySingleton.createString();
        //LazySingleton.getInstance();
    }


}
