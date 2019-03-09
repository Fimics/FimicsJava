package com.mic.java8.collector;

import com.mic.java8.bean.Student;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



public class StreamComparatorDemo {

    public static void main(String[] args) {
        Student s1 = new Student("zhangsan",100,20);
        Student s2 = new Student("lishi",90,20);
        Student s3 = new Student("wangwu",90,30);
        Student s4 = new Student("zhaoliu",80,300);
        Student s5 = new Student("chenqi",80,20);


        List<Student> list = Arrays.asList(s1,s2,s3,s4,s5);
        List<String>  stringList = Arrays.asList("nihao","hello","world","welcome");

        //Collections.sort(stringList, Comparator.naturalOrder());
        Collections.sort(stringList,Comparator.comparingInt(String::length));
        Collections.sort(stringList,Comparator.reverseOrder());

        Collections.sort(stringList,Comparator.comparingInt((String item)->item.length()).reversed());

        stringList.forEach(System.out::println);
    }
}
