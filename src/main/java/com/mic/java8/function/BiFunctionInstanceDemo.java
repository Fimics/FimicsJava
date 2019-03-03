package com.mic.java8.function;

import com.mic.java8.bean.Person;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class BiFunctionInstanceDemo {

    private static List<Person> persons;

    static {
        Person p1 = new Person("java",20);
        Person p2 = new Person("c",60);
        Person p3 = new Person("kotlin",10);
        persons = Arrays.asList(p1,p2,p3);
    }

    public static void main(String[] args) {
          BiFunctionInstanceDemo demo = new BiFunctionInstanceDemo();
          List<Person> results = demo.getPersonsByName("java",persons);
          System.out.println(results);

          System.out.println("---------------------");

          List<Person> peoples = demo.getPersonByAge(10,persons);
          System.out.println(peoples);

          List<Person> personList = demo.getPersonsByFun(15,persons,(age,ps)->
              ps.stream().filter(person -> person.getAge()>age).collect(Collectors.toList())
          );

        System.out.println(personList);
    }

    private List<Person> getPersonsByName(String name,List<Person> persons){
        return persons.stream()
                        .filter(person -> person.getUsername().equals("java"))
                        .collect(Collectors.toList());
    }

    private List<Person> getPersonByAge(int age,List<Person> persons){
        BiFunction<Integer,List<Person>,List<Person>> function =(pAge,personList)->
            personList.stream().filter(person -> person.getAge()>pAge).collect(Collectors.toList());
        return  function.apply(age,persons);
    }

    private List<Person> getPersonsByFun(int age,List<Person> personList,BiFunction<Integer,List<Person>,List<Person>> function){
        return function.apply(age,personList);
    }
}
