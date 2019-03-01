package com.mic.design.template;

/**
 * Created by lipengju on 2018/5/26.
 */
public class BossWork extends AbstractWork {
    @Override
    protected void getToWork() {
        System.out.println("Boss getToWork");
    }

    @Override
    protected void work() {
        System.out.println("work");
    }

    @Override
    protected void getOffWork() {
        System.out.println("getOffWork");
    }
}
