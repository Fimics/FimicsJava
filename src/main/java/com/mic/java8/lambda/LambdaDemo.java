package com.mic.java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LambdaDemo {

    public static void main(String[] args) {

        testCollections();
    }

    public static void testCollections(){

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);

        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });

        System.out.println("-----------------------");

        list.forEach(integer -> System.out.println(integer));
        //通过方法引用::(method reference)创建lambda表达式
        list.forEach(System.out::println);
    }


}
