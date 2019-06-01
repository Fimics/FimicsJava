package com.mic.thread.atomic;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {

    /**
     * 让simple类型具有了原子性
     */
    AtomicReference<Simple> reference = new AtomicReference<>();

    @Before
    public void setUp() throws Exception {

        Simple simple = new Simple("jack",33);
        reference.set(simple);

        System.out.println(reference.get());

        System.out.println(reference.compareAndSet(simple,new Simple("jack1",32)));
        System.out.println(simple);

    }

    @Test
    public void name() {
    }


    static class Simple{
        private String name;
        private int age;

        public Simple(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Simple{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
