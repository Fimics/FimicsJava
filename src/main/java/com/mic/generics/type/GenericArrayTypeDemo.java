package com.mic.generics.type;

import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.util.List;

/**
 * GenericArrayType
 * 泛型数组,组成数组的元素中有范型则实现了该接口; 它的组成元素是ParameterizedType或TypeVariable类型,它只有一个方法:
 * <p>
 * Type getGenericComponentType(): 返回数组的组成对象
 *
 * @param <T>
 */
public class GenericArrayTypeDemo<T> {

    List<String>[] lists;

    public static void main(String[] args) throws Exception {
        Field f = GenericArrayTypeDemo.class.getDeclaredField("lists");
        GenericArrayType genericType = (GenericArrayType) f.getGenericType();
        System.out.println(genericType.getGenericComponentType());
    }
}

