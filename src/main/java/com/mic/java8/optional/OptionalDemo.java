package com.mic.java8.optional;


import com.mic.java8.bean.Company;
import com.mic.java8.bean.Person;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class OptionalDemo {

    static Company company = new Company("yixia");

    static {
        Person p1 = new Person("java", 20);
        Person p2 = new Person("c", 60);
        Person p3 = new Person("kotlin", 10);

        List<Person> peoples = Arrays.asList(p1, p2, p3);
        peoples=null;
        company.setEmployees(peoples);
    }

    public static void main(String[] args) {
        OptionalDemo demo = new OptionalDemo();

        String a = "a";
        Optional<String> optional = Optional.empty();
        Optional<String> optional1 = Optional.of(a);//确定不为null使用这个
        Optional<String> optional2 = Optional.ofNullable(a);//不确定是否为空

        //比如从查询数据库，如果集合不为空直接返回，如果为空，要返回一个空集合，而不是返回null

       /*
       不推荐这么使用
       if(optional.isPresent()){
            System.out.println(optional.get());
        }*/

        //推荐使用
//        optional.ifPresent(it -> System.out.println(it));
//        System.out.println(optional.orElse("hello"));
//        System.out.println(optional.orElseGet(() -> "java"));

        System.out.println(Optional.ofNullable(company)
                .map(opc->opc.getEmployees())
                .orElse(Collections.emptyList()));

    }
}
