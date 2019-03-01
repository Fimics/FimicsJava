package com.mic.design.facade;

/**
 * Created by lipengju on 2018/5/26.
 * 外观类是单列的
 */
public class Facade {

    private ModuleA moduleA=null;
    private ModuleB moduleB=null;
    private ModuleC moduleC = null;

    private Facade(){
        moduleA=new ModuleA();
        moduleB=new ModuleB();
        moduleC=new ModuleC();
    }

    public static Facade getInstance(){
        return FacadeHolder.INSTANCE;
    }


    public void testFunA(){
        moduleA.testFuncA();
    }


    public void testFunB(){
        moduleB.testFuncB();
    }

    public void testFunC(){
        moduleC.testFuncC();
    }

    private static class FacadeHolder{
        private static final Facade INSTANCE= new Facade();
    }

}
