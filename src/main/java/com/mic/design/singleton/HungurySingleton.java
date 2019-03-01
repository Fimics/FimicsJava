package com.mic.design.singleton;

/**
 * Created by lipengju on 2018/5/24.
 * 饿汉不足之处:不能延迟加载
 */
public class HungurySingleton {

    private static final HungurySingleton instace = new HungurySingleton();

    private HungurySingleton(){
        System.out.println(" singleton is create");
    }

    public static  HungurySingleton getInstace(){
        return  instace;
    }

    public static  void createString(){
        System.out.println("createString in singleton");
    }

    public static void main(String args[]){
        HungurySingleton.createString();
    }

}
