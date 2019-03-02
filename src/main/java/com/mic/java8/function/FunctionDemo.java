package com.mic.java8.function;

import java.util.*;
import java.util.function.Function;

public class FunctionDemo {
    static List<String> list = Arrays.asList("java","python","android","ios","javaScript","kotlin",
            "c","c++","lisp","ruby","swfit","groovy");

    public static void main(String[] args) {

        //Function<String,String> function =String::toUpperCase;//输入String,返回String

        //list.forEach(l-> System.out.println(function.apply(l)));

        compare();
        System.out.println(compute(1,value->{return  2*value;}));
        System.out.println(compute(2,value->value*value));
        System.out.println(convert(250,value->"you are :"+value));

        Function<Integer,Integer> function = value->value+4;
        System.out.println(function.apply(5));
        System.out.println("-----------------------------------------------------");

        System.out.println(composeFun(2,value->value*3,value->value*value));
        System.out.println(andThenFun(2,value->value*3,value->value*value));
    }


    public static void compare(){

//        Collections.sort(list, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o2.compareTo(o1);
//            }
//        });

//        Collections.sort(list,(String o1,String o2)-> {
//            return o2.compareTo(o1);
//        });

       // Collections.sort(list,(o1,o2)->{return o2.compareTo(o1);});

        //o2.compareTo(o1) 表达式 |{return o2.compareTo(o1);} 语句
        Collections.sort(list,(o1,o2)->o2.compareTo(o1));

        //Collections.sort(list,Comparator.reverseOrder());

        System.out.println(list);
    }

    //apply

    public static int compute(int a,Function<Integer,Integer> function){
        int result = function.apply(a);
        return result;
    }

    public static String convert(int a,Function<Integer,String> function){
        return  function.apply(a);
    }


   /* default <V> Function<V, R> compose(Function<? super V, ? extends T> before) {
        Objects.requireNonNull(before);
        return (V v) -> apply(before.apply(v));
    }*/

    //compose
    //System.out.println(composeFun(2,value->value*3,value->value*value));
    //1.after--> 2*2 =4--> 4*3=12
    public static int composeFun(int a,Function<Integer,Integer> before,Function<Integer,Integer> after){
        return before.compose(after).apply(a);
    }

   /* default <V> Function<T, V> andThen(Function<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (T t) -> after.apply(apply(t));
    }*/


    //System.out.println(composeFun(2,value->value*3,value->value*value));
    //andThen
    //1.2*3=6-->6*6=36
    public static int andThenFun(int a,Function<Integer,Integer> before,Function<Integer,Integer> after){
        return before.andThen(after).apply(a);
    }
}
