package com.mic.kotlin;

import com.mic.kotlinjava.Person;

public class JavaCallKotlinKJvmField {

    public static void main(String[] args) {
        Person person = new Person();

        System.out.println(person.getName());
        System.out.println(person.age);
    }
}
