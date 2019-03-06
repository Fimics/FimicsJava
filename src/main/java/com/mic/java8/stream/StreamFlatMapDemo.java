package com.mic.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFlatMapDemo {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("hello android","world","hello world","java c","hello","python","world");

        list.stream()
                .map(item->item.split(" "))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("---------------------");

        List<String> list1 =Arrays.asList("hi","hello","您好");
        List<String> list2 = Arrays.asList("zhangsan","lishi","wangwu","zhaoliu");

        list1.stream()
                .flatMap(item->list2.stream().map(item2->item+" :"+item2))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("---------------------");



    }
}
