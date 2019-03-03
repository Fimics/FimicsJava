package com.mic.java8.function;

import com.mic.java8.bean.Person;

import java.util.function.Supplier;

/**
 * supplier 不接收参数返回一个对象
 */
public class SupplierDemo {

    public static void main(String[] args) {
        Supplier<Person> supplier = ()-> new Person();
        System.out.println(supplier.get().getAge());

        Supplier<Person> supplier1=Person::new;
        System.out.println(supplier1.get().getUsername());
    }
}
