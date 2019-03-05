package com.mic.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMapDemo {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("hello","world");

        list.stream()
                .map(item->item.toUpperCase())
                .collect(Collectors.toList())
                .forEach(System.out::println);


        System.out.println("---------------------");
        Stream<List<Integer>> stream = Stream.of(Arrays.asList(1),Arrays.asList(2),Arrays.asList(3));
        System.out.println(stream.flatMap(thelist->thelist.stream())
                .map(integer -> integer*integer)
                .collect(Collectors.toList())
                .stream()
                .reduce(Integer::sum)
                .get());



    }
}
