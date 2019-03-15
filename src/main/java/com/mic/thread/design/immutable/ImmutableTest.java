package com.mic.thread.design.immutable;

import java.util.Collections;
import java.util.List;

@SuppressWarnings("unused")
public class ImmutableTest {

    private final int age;
    private final String name;
    private  List<String> list;

    public ImmutableTest(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public List<String> getList() {
        //return list; //别人拿到这个可以往list中加数据，还是可能修改的，
        return Collections.unmodifiableList(list);//这样就不可变了
    }
}
