package com.mic.design.composite;

/**
 * Created by lipengju on 2018/5/26.
 */
public class TextFile extends File {

    public TextFile(String name) {
        super(name);
    }

    @Override
    public void watch() {
        System.out.println("组合模式"+"这是一个叫"+getName()+" 文本文件" );
    }
}
