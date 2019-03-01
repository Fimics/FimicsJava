package com.mic.design.decorator;

/**
 * Created by lipengju on 2018/5/26.
 */
public class ConCreatorDecorator  extends Decorator{


    public ConCreatorDecorator(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        this.addedBehavior();
    }

    public void addedBehavior(){
        //// TODO: 2018/5/26
    }
}
