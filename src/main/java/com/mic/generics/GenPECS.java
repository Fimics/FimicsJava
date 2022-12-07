package com.mic.generics;

import java.util.ArrayList;
import java.util.List;

public class GenPECS {

    //PECS原则
    //https://www.dazhuanlan.com/2019/12/05/5de8d53d4998c/ 协变逆变
    public static void main(String[] args) {
        new GenPECS().testPECS();
    }


    private void testPECS() {
        List<? extends Animal> animals = new ArrayList<>();
//        animals.add(new Dog()); //error
//        animals.add(new Cat()); //error
//        animals.add(new Animal());//error
        animals.add(null); //right
        /**
         *不可以往这个List中添加Animal类型以及其子类 因为对于set方法，
         * 编译器无法知道具体的类型，所以会拒绝这个调用。但是，如果是get方法形式 的调用，则是允许的：
         */

        List<? extends Animal> list1 = new ArrayList<>();
        List<Dog> list4 = new ArrayList<>();
        list4.add(new Dog());
        list4.add(new Dog());
//        animal.act(list4);
         list1 = list4;
//        animal.act(list1);
    }


    class Animal {
        public void act(List<? extends Animal> list) {
            for (Animal animal : list) {
                animal.eat();
            }
        }

        public void aboutShepherdDog(List<? super ShepherdDog> list) {
            System.out.println("About ShepherdDog");
        }

        public void eat() {
            System.out.println("Eating");
        }
    }

    class Dog extends Animal {
    }

    class Cat extends Animal {
    }

    class ShepherdDog extends Dog {
    }

}
