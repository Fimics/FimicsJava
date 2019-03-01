package com.mic.design.responsibilitychain;

/**
 * Created by lipengju on 2018/5/27.
 */
public class Boss extends Handler {

    public Boss(int maxDay) {
        super(maxDay);
    }

    @Override
    protected void replay(int day) {
        System.out.println("老板处理...");
    }
}
