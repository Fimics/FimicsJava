package com.mic.design.builder;

/**
 * Created by lipengju on 2018/5/26.
 * Builder模式指挥类
 */
public class Director {

    private Builder builder;

    public Director(Builder builder){
        this.builder=builder;
    }

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }


    public Product construct(){
        builder.buildPartA();;
        builder.buildPartB();
        return  builder.getResult();
    }


}
