package com.mic.design.builder;

/**
 * Created by lipengju on 2018/5/26.
 */
public class BuilderClient {


    public static void main(String args[]){
        Builder builder = new ConcreateBuilder();
        Director director = new Director(builder);
        Product product = director.construct();
    }
}
