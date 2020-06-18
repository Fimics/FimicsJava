package com.mic.java8.bean;

import java.util.Objects;

public class Person {

    private String username="steven";
    private int age=20;

    public Person() {
    }

    public Person(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        kotlin.test.Person person = (kotlin.test.Person) o;
//        return getAge() == person.getAge() &&
//                Objects.equals(getUsername(), person.getUsername());
//    }

    public static String getId(Person person){
        return String.valueOf(person.hashCode());
    }

    public static int compareByAge(Person p1,Person p2){
        return p1.getAge()-p2.getAge();
    }

    public int compareByName(Person person){
        return this.getUsername().compareTo(person.getUsername());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(username, person.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsername(), getAge());
    }

    @Override
    public String toString() {
        return "kotlin.test.Person{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
