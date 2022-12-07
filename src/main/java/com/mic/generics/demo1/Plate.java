package com.mic.generics.demo1;

//泛型类
public class Plate<T> implements IPlate<T>{

    private T mt;

    @Override
    public void set(T t) {
          this.mt = t;
    }

    @Override
    public T get() {
        return mt;
    }

    //泛型方法
    public <T> Plate<T> getAiPlate(){
        return new Plate<T>();
    }
}
