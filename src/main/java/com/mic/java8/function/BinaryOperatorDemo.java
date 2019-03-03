package com.mic.java8.function;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class BinaryOperatorDemo {

    public static void main(String[] args) {
        BinaryOperatorDemo demo = new BinaryOperatorDemo();
        System.out.println(demo.compute(1,2,(a,b)->a+b));
        System.out.println(demo.getShort("java","python",(a,b)->a.length()-b.length()));
    }

    public int compute(int a, int b, BinaryOperator<Integer> operator){
        return operator.apply(a,b);
    }

    public String getShort(String a, String b, Comparator<String> comparator){
        return BinaryOperator.maxBy(comparator).apply(a,b);
    }
}
