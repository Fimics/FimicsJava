package com.mic.java8.stream;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

    static List<String> list = Arrays.asList("java","python","android","ios","javaScript","kotlin",
                                            "c","c++","lisp","ruby","swfit","groovy");

    public static void main(String[] args) {

        Stream<String> stream = Stream.of("java","python","android","ios","javaScript","kotlin",
                "c","c++","lisp","ruby","swfit","groovy");

        /*list.stream().map(item->item.toUpperCase())
                     .forEach(l-> System.out.println(l));

        System.out.println("---------------------------");

        list.stream().map(String::toUpperCase)
                    .forEach(System.out::println);

        String [] strings = stream.toArray(length->new String[length]);
        Arrays.asList(strings).forEach(item-> System.out.println(item));*/

//        String [] strings = stream.toArray(String[]::new);
//        Arrays.asList(strings).forEach(System.out::println);

        //List<String> list =stream.collect(Collectors.toList());
        //List<String> list = stream.collect(()->new ArrayList(),(theList,item)->theList.add(item),(list1,list2)->list1.add(list2));
        //List<String> list = stream.collect(LinkedList::new,LinkedList::add,LinkedList::addAll);
//        List<String> list = stream.collect(Collectors.toCollection(ArrayList::new));
//        Set<String> set = stream.collect(Collectors.toCollection(TreeSet::new));
//        list.forEach(System.out::println);

    }


}
