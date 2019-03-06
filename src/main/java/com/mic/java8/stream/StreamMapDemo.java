package com.mic.java8.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.UUID;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMapDemo {

    public static void main(String[] args) {

       List<String> list = Arrays.asList("hello android","world","hello world","java c","hello","python","world");

       /*
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
        Stream stream2 =Stream.iterate(1, item -> item+2).limit(10);*/
        //stream2.forEach(System.out::println);

//        System.out.println(stream2.filter(item -> (Integer)item>2)
//                                  .mapToInt(item->(Integer)item*2)
//                                  .skip(2)
//                                  .limit(2)
//                                  .sum());

        /*stream2.filter(item -> (Integer)item>2)
                .mapToInt(item->(Integer)item*2)
                .skip(2)
                .limit(2)
                .min()
                .ifPresent(System.out::println);*/


       /* IntSummaryStatistics statistics=stream2.filter(item -> (Integer)item>2)
                .mapToInt(item->(Integer)item*2)
                .skip(2)
                .limit(2)
                .summaryStatistics();

        System.out.println(statistics.getAverage());
        System.out.println(statistics.getCount());


        IntStream.iterate(0,i->(i+1)%2).limit(6).distinct().forEach(System.out::println);*/


       /*list.stream().mapToInt(item->item.length())
                    .filter(length->length==5)
                    .findFirst()
                    .ifPresent(System.out::println);*/

       /*list.stream().mapToInt(item->{
           int length = item.length();
           System.out.println(item);
           return length;
       }).findFirst().ifPresent(System.out::println);
*/



    }
}
