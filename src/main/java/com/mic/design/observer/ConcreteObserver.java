package com.mic.design.observer;

/**
 * 创 建 人: lipengju
 * 创建日期: 2018/4/12 17:26
 * 文件描述：
 */


public class ConcreteObserver implements Observer {

    private int id;

    public ConcreteObserver(int id) {
        this.id = id;
    }


    @Override
    public void update() {

        System.out.println("id= "+id+" "+this.toString());
    }
}
