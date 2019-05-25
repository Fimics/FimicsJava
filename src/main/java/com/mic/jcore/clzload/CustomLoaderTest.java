package com.mic.jcore.clzload;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CustomLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {

        CustomClassLoader loader = new CustomClassLoader("loader");
        Class clazz =loader.findClass("com.mic.jcore.clzload.MyObject");
        System.out.println(clazz);
        System.out.println(clazz.getClassLoader());

        Object obj = clazz.newInstance();
        Method methods[] = clazz.getDeclaredMethods();

        for(Method method:methods){
            System.out.println(method.getName());
            String result = (String) method.invoke(obj,new Object[]{});
            System.out.println(result);
        }
    }
}
