package com.mic.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * 类型擦除 协变与不变,数组是协变的，而List是不变的。简单来说，就是Object[]是所有对象数组的父类，而List<Object>却不是List<T>的父类。
 */
public class K4_TypeErasure {

    public static void main(String[] args) {

        Apple[] appleArray = new Apple[10];
        Fruit[] fruitArray = appleArray;//允许
        //fruitArray[0] = new Banner(1.5);//编译报错

        List<Apple> appleList = new ArrayList<Apple>();
//        List<Fruit> fruitList = appleList  //不允许


        /**
         * Apple[]类型的值可以赋值给Fruit[]类型的值，而且还可以将一个Banana对象添加到fruitArray，
         * 编译器能通过。作为对比，List<Friut>类型的值则在一开始就禁止被赋值为List<Apple>类型的值，这其中到底有什么不同呢？
         *
         * 1.其实这里涉及一个关键点，数组是协变的，而List是不变的。简单来说，就是Object[]是所有对象数组的父类，而List<Object>却不是List<T>的父类。
         * 2.Java中的泛型是类型擦除的，可以看作伪泛型，简单来说，就是你无法在程序运行时获取到一个对象的具体类型
         *
         * 3.数组在运行时是可以获取自身的类型，而List<Apple>在运行时只知道自己是一个List，而无法获取泛型参数的类型。
         * 而Java数组是协变的，也就是说任意的类A和B，若A是B的父类，则A[]也是B[]的父类。但是假如给数组加入泛型后，
         * 将无法满足数组协变的原则，因为在运行时无法知道数组的类型。
         */

        System.out.println(appleArray.getClass()); // class [Lcom.mic.javagenerics.J4_TypeErasure$Apple;
        System.out.println(appleList.getClass());  // class java.util.ArrayList


    }

    /**
     * 1
     * java 为何无法声明一个泛型数据组？
     * Apple[] : Fruit[] ,List<Apple> :List<Fruit> 是什么关系？
     */
    static class Fruit{}
    static class Apple extends Fruit{}
    static class Banner extends Fruit{

        private double widget;
        public Banner(double widget) {
            this.widget = widget;
        }
    }

}



