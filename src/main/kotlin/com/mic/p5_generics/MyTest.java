package com.mic.p5_generics;

// PECS: Producer Extends, Consumer Super.

import java.util.ArrayList;
import java.util.List;

// PECS: Producer Extends, Consumer Super.


public class MyTest {

    public static void main(String[] args) {
//        List<String> list = new ArrayList<String>();
//        List<Object> list2 = list;
//        list2.add(3);
//        String str = list2.get(0);

//        List<Cat> cats = new ArrayList<>();
//        List<? extends Animal> animals = cats;
//        协变只允许读取，逆变只允许写入
//        animals.add(new Cat());

        List<Animal> animals = new ArrayList<>();
        List<? super Animal> contravariantAnimals = animals;

//        List<Object> list = new ArrayList<>();
//        contravariantAnimals = list;

        contravariantAnimals.add(new Cat());
        contravariantAnimals.add(new Dog());
//        contravariantAnimals.add(new Object());

//        contravariantAnimals.get(0);

        Object[] objs = new String[]{"hello", "world"};
        objs[0] = new Object();

    }
}

class Animal {

}

class Cat extends Animal {

}

class Dog extends Animal {

}
