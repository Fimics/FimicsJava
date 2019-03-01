package com.mic.design.builder;

/**
 * Created by lipengju on 2018/5/26.
 * 抽像构建者
 */
abstract class Builder {

    protected  Product product = new Product();

    public abstract void buildPartA();
    public abstract void buildPartB();
    public abstract void buildPartC();

    public Product getResult(){
        return  product;
    }
}
