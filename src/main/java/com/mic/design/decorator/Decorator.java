package com.mic.design.decorator;

/**
 * Created by lipengju on 2018/5/26.
 */
public class Decorator implements  Component {

    private Component component;

    public Decorator(Component component) {

        this.component = component;
    }

    @Override
    public void operation() {
        //具体的装饰交给子类完成
        this.component.operation();
    }
}
