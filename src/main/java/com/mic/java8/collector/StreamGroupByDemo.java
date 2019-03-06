package com.mic.java8.collector;

import com.mic.java8.bean.Student;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StreamGroupByDemo {

    public static void main(String[] args) {
        Student s1 = new Student("zhangsan",100,20);
        Student s2 = new Student("lishi",90,20);
        Student s3 = new Student("wangwu",90,30);
        Student s4 = new Student("zhaoliu",80,40);


        List<Student> students = Arrays.asList(s1,s2,s3,s4);


        /*students.stream()
                .collect(Collectors.groupingBy(student -> student.getScore()))
                .entrySet()
                .forEach(item-> System.out.println("key:"+item.getKey()+" value: "+item.getValue().toString()));
*/

       /* students.stream()
                .collect(Collectors.groupingBy(Student::getScore))
                 .entrySet().forEach(System.out::println);*/

        /*students.stream()
                .collect(Collectors.groupingBy(Student::getScore,Collectors.counting()))
                .entrySet().forEach(System.out::println);*/

        /*students.stream()
                .collect(Collectors.groupingBy(Student::getAge,Collectors.averagingDouble(Student::getScore)))
                .entrySet().forEach(System.out::println);*/

        //分区只有 true /false 两种
        students.stream()
                .collect(Collectors.partitioningBy(student -> student.getScore()>=90))
                .entrySet().forEach(System.out::println);
    }
}
