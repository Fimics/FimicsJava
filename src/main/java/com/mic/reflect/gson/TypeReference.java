package com.mic.reflect.gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class TypeReference<T> {
    Type type;
    T t;

    protected TypeReference() {
        //获得泛型类型
        Type genericSuperclass = getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        //因为类泛型可以定义多个  A<T,E..> 所以是个数组
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        type = actualTypeArguments[0];
    }

    public Type getType() {
        return type;
    }
}
