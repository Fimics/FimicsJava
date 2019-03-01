package com.mic.design.template;

/**
 * Created by lipengju on 2018/5/26.
 */
public abstract class AbstractWork {

    protected void getUp(){
        System.out.println("起床。。。");
    }

    protected abstract void getToWork();

    protected abstract void work();

    protected abstract void getOffWork();


    /**
     * 大家都拥有的共同执行步骤
     */
    public final  void newDay(){
        getUp();
        getOffWork();
        work();
        getOffWork();
    }

}
