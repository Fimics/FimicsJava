package com.mic.design.template;

/**
 * Created by lipengju on 2018/5/26.
 */
public class StaffWork extends AbstractWork {
    @Override
    protected void getToWork() {
        System.out.println("Staff getToWork");
    }

    @Override
    protected void work() {
        System.out.println("Staff work");
    }

    @Override
    protected void getOffWork() {
        System.out.println("Staff getOffWork");
    }
}
