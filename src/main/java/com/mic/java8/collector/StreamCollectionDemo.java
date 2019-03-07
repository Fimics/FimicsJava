package com.mic.java8.collector;

import com.mic.java8.bean.Student;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamCollectionDemo {

    public static void main(String[] args) {
        Student s1 = new Student("zhangsan",100,20);
        Student s2 = new Student("lishi",90,20);
        Student s3 = new Student("wangwu",90,30);
        Student s4 = new Student("zhaoliu",80,40);


        List<Student> list = Arrays.asList(s1,s2,s3,s4);
        List<Student> list1 =list.stream().collect(Collectors.toList());
        list1.forEach(System.out::println);

        System.out.println("-------------------");

        System.out.println(list.stream().collect(Collectors.counting()));
        System.out.println(list.stream().count());



    }
}
