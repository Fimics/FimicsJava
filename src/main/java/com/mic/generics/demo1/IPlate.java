package com.mic.generics.demo1;

//泛型接口
public interface IPlate<T> {
    public void set(T t);
    public T get();
}
