package com.mic.java8.function;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
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

    public static int compute(int a,Function<Integer,Integer> function){
        int result = function.apply(a);
        return result;
    }

    public static String convert(int a,Function<Integer,String> function){
        return  function.apply(a);
    }
}
