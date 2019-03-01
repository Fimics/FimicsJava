package com.mic.design.facade;

/**
 * Created by lipengju on 2018/5/26.
 */
public class Client {

    public static void main(String args[]){
        Facade facade = Facade.getInstance();
        facade.testFunA();
        facade.testFunB();
        facade.testFunC();
    }
}
