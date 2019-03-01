package com.mic.design.observer;

/**
 * 创 建 人: lipengju
 * 创建日期: 2018/4/12 17:22
 * 文件描述：
 */


public class ObserverTest {

    static Observerable observerable = new ConcreteObserverable();

    public static void main(String args[]){

        Observer o1 = new ConcreteObserver(1);
        Observer o2 = new ConcreteObserver(2);
        Observer o3 = new ConcreteObserver(3);
        Observer o4 = new ConcreteObserver(4);
        Observer o5 = new ConcreteObserver(5);

        observerable.registerObserver(o1);
        observerable.registerObserver(o2);
        observerable.registerObserver(o3);
        observerable.registerObserver(o4);
        observerable.registerObserver(o5);
        observerable.notfiyOberver();


    }
}
