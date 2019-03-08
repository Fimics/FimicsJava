package com.mic.java8.collector;

import com.mic.java8.bean.Student;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.*;

public class StreamCollectionDemo {

    public static void main(String[] args) {
        Student s1 = new Student("zhangsan",100,20);
        Student s2 = new Student("lishi",90,20);
        Student s3 = new Student("wangwu",90,30);
        Student s4 = new Student("zhaoliu",80,300);
        Student s5 = new Student("chenqi",80,20);


        List<Student> list = Arrays.asList(s1,s2,s3,s4,s5);
        List<Student> list1 =list.stream().collect(Collectors.toList());
        list1.forEach(System.out::println);

        System.out.println("-------------------");

        System.out.println(list.stream().collect(Collectors.counting()));
        System.out.println(list.stream().count());

        list.stream().min(Comparator.comparingInt(Student::getScore)).ifPresent(student -> System.out.println(student.getName()));

        list.stream().collect(Collectors.minBy(Comparator.comparingInt(Student::getScore))).ifPresent(System.out::println);

        System.out.println(list.stream().collect(averagingInt(Student::getScore)));
        System.out.println(list.stream().collect(summingInt(Student::getScore)));
        System.out.println(list.stream().collect(summarizingInt(Student::getScore)));

        System.out.println("-------------------");
        System.out.println(list.stream().map(Student::getName).collect(joining(" , ")));

        System.out.println(list.stream().map(Student::getName).collect(joining(", ","<xml>","</xml>")));

        list.stream().collect(groupingBy(Student::getScore,groupingBy(Student::getAge))).entrySet().forEach(System.out::println);


        System.out.println("-------------------");
       list.stream()
               .collect(partitioningBy(student -> student.getScore()>80
                       ,partitioningBy(student -> student.getScore()>20)))
                        .entrySet()
                        .forEach(System.out::println);



       list.stream().collect(groupingBy(student -> student.getScore()>80,counting())).entrySet().forEach(System.out::println);

       list.stream().collect
               (groupingBy(Student::getName,
               collectingAndThen(minBy(Comparator.comparingInt(Student::getScore)), Optional::get)))
               .entrySet()
               .forEach(System.out::println);
    }
}
