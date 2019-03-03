package com.mic.java8.bean;

public class BeanHelper {



    public int comparePersonByName(Person p1,Person p2){
        return  p1.getUsername().compareTo(p2.getUsername());
    }
}
