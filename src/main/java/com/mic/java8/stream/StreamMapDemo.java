package com.mic.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMapDemo {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("hello","world");
        list.stream()
                .map(item->item.toUpperCase())
                .collect(Collectors.toList())
                .forEach(System.out::println);

    }
}
