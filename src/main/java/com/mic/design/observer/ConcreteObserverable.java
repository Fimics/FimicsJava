package com.mic.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 创 建 人: lipengju
 * 创建日期: 2018/4/12 17:27
 * 文件描述：
 */


public class ConcreteObserverable implements Observerable {

    private List<Observer> list = new ArrayList<Observer>();

    @Override
    public void registerObserver(Observer observer) {
        list.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
       list.remove(observer);
    }

    @Override
    public void notfiyOberver() {

        for (Observer observer:list) {
            observer.update();
        }
    }
}
