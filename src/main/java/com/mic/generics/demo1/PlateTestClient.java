package com.mic.generics.demo1;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.Map;

public class PlateTestClient {

    /**
     * 泛型擦除后的类型
     * 1.T ->object
     * 2. T extends A  T super A  ->A
     *
     * @param args
     */

    public static void main(String[] args) {
        TestType testType = new TestType();
        testType.info();
    }

    /**
     * 擦除，其实在类常量池里保留了泛型信息
     */
    private static class TestType {
        Map<String, String> map;

        private void info(){
            try {
                Field f = TestType.class.getDeclaredField("map");
                System.out.println("getGenericType ->"+f.getGenericType());
                System.out.println(f.getGenericType() instanceof ParameterizedType);
                ParameterizedType pType = (ParameterizedType) f.getGenericType();
                System.out.println("pType->"+pType);
                System.out.println("getRawType  ->"+pType.getRawType());
                System.out.println("getActualTypeArguments ->"+pType.getActualTypeArguments()[0]);
                System.out.println("getOwnerType ->"+pType.getOwnerType());
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }


    }
}
