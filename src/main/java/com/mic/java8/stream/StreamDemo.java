package com.mic.java8.stream;


import java.util.Arrays;
import java.util.List;

public class StreamDemo {

    static List<String> list = Arrays.asList("java","python","android","ios","javaScript","kotlin",
                                            "c","c++","lisp","ruby","swfit","groovy");

    public static void main(String[] args) {

        list.stream().map(item->item.toUpperCase())
                     .forEach(l-> System.out.println(l));

        System.out.println("---------------------------");

        list.stream().map(String::toUpperCase)
                    .forEach(System.out::println);

    }


}
