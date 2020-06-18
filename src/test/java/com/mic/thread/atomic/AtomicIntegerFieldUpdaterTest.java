package com.mic.thread.atomic;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicIntegerFieldUpdaterTest {

    AtomicIntegerFieldUpdater<Person> updater;

    @Before
    public void setUp() throws Exception {
        updater = AtomicIntegerFieldUpdater.newUpdater(Person.class, "age");
    }

    @Test
    public void testFieldUpdater() {
        Person person = new Person("jack",20);
        updater.set(person,33);
        System.out.println(person);
    }


    class Person {

        public volatile int age;
        public String name;

        public Person() {
        }

        public Person(String name,int age) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return "kotlin.test.Person{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
