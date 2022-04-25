package com.mic.jcore.clzload;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CustomLoaderTest2 {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {

        CustomClassLoader loader = new CustomClassLoader("loader");
        CustomClassLoader loader2 = new CustomClassLoader("loader2",loader);
        loader2.setDir("/Users/lipengju/code/java/FimicsJava/clazz1/");
        Class clazz =loader2.findClass("com.mic.jcore.clzload.MyObject");
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
