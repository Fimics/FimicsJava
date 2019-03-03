package com.mic.java8.function;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;

public class BiFunctionDemo {

    public static void main(String[] args) {

        System.out.println(compute(1,2,(v1,v2)->v1+v2));
        System.out.println(andThenFun(2,3,(v1,v2)->v1+v2,v->v*v));
    }

   /*
   R apply(T t, U u); 两个输入一个输出
   */
    public static Integer compute(int a, int b, BiFunction<Integer,Integer,Integer> biFunction){
        return biFunction.apply(a,b);
    }

   /* default <V> BiFunction<T, U, V> andThen(Function<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (T t, U u) -> after.apply(apply(t, u));
    }*/
    public static Integer andThenFun(int a,int b,BiFunction<Integer,Integer,Integer> biFunction,Function<Integer,Integer> function){
        return  biFunction.andThen(function).apply(a,b);
    }

}
