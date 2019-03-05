package com.mic.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.function.UnaryOperator;
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



        Stream stream1 = Stream.generate(UUID.randomUUID()::toString);
        stream1.findFirst().ifPresent(System.out::println);


        List<Integer> list1 =Arrays.asList(1,2,3,4,5);
        //step
        Stream stream2 =Stream.iterate(1, integer -> integer*2).limit(30);
        stream2.forEach(System.out::println);


    }
}
