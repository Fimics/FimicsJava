package com.mic.generics;

import java.util.ArrayList;
import java.util.List;

public class GenDemo {
    //PECS原则
    //https://www.dazhuanlan.com/2019/12/05/5de8d53d4998c/ 协变逆变
    public static void main(String[] args) {
        /**
         * 在Java中，因为 Integer 是 Number 的子类型，数组类型 Integer[] 也是 Number[] 的子类型，
         * 因此 在任何需要 Number[] 值的地方都可以提供一个 Integer[] 值。
         */
        Integer[] ints = new Integer[3];
        ints[0] = 0;
        ints[1] = 1;
        ints[2] = 2;
        Number[] numbers = new Number[3];
        numbers = ints;
        for (Number n : numbers) {
            System.out.println(n);
        }

        /**
         * 而另一方面，泛型不是协变的。也就是说， List 不是 List 的子类型，
         * 试图在要求 List 的位置提供 List 是一个类型错误。下面的代码，编译器是会直接报错的：
         */

        List<Integer> integerList = new ArrayList<>();
        integerList.add(0);
        integerList.add(1);
        integerList.add(2);
        List<Number> numberList = new ArrayList<>();
//        numberList = integerList; 出错

        /**
         * Java中泛型和数组的不同行为，的确引起了许多混乱。 就算我们使用通配符，这样写：一样报错
         * 为什么Number的对象可以由Integer实例化，而ArrayList的对象却不能由ArrayList实例化？
         * list中的 <? extends Number>声明其元素是Number或Number的派生类，为什么不能add Integer?
         * 为了解决 这些问题，需要了解Java中的逆变和协变以及泛型中通配符用法。
         */
        List<? extends Number> list = new ArrayList<Number>();
        //list.add(new Integer(1)); //error

        /**
         * 逆变与协变 Animal类型（简记为F, Father）是Dog类型（简记为C, Child）的父类型，我们把这种父子类型关系
         * 简记为F <| C。 而List, List的类型，我们分别简记为f(F), f(C)。
         */

        /**
         * 当F <| C 时, 如果有f(F) <| f(C),那么f叫做协变（Convariant）；
         * 当F <| C 时, 如果有f(C) <| f(F), 那么f叫做逆变（Contravariance)
         * 如果上面两种关系都不成立则叫做不可变。
         */
        // List<Animal> list = List<Dog>
//        List<Integer> integerList = new ArrayList<>();
//        List<Number> numberList = new ArrayList<>();
//        numberList = integerList; 出错
    }
}
