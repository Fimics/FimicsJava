package com.mic.java8.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(0,1,2,3,4,5,6,7,8,9);
        PredicateDemo demo = new PredicateDemo();

        Predicate<String> predicate =p->p.length()>5;
        System.out.println(predicate.test("hello world"));

        demo.conditionFilter(list,integer -> integer%2==0);
        demo.conditionFilter(list,item->item>3);
        demo.conditionFilter(list,integer -> true);
        demo.conditionFilter(list,integer -> false);

        demo.filter(list,f->f>3,s->s%2==0);

        String  s = "hello";
        System.out.println(demo.isEqual(s).test("hello"));

    }

    private void conditionFilter(List<Integer> list,Predicate<Integer> predicate){

        list.forEach(integer -> {
            if(predicate.test(integer)){
                System.out.println(integer);
            }
        });
        System.out.println("-------------------");
    }

    private void filter(List<Integer> list,Predicate<Integer> first,Predicate<Integer> second){

        list.forEach(integer -> {
            if(first.negate().test(integer)){
                System.out.println(integer);
            }
        });
        System.out.println("--------------");
        list.forEach(integer -> {
            if(first.and(second).test(integer)){
                System.out.println(integer);
            }
        });

        System.out.println("--------------");
        list.forEach(integer -> {
            if(first.or(second).test(integer)){
                System.out.println(integer);
            }
        });

        System.out.println("-------------");
    }

    private Predicate<String>  isEqual(Object object){
       return Predicate.isEqual(object);
    }


}
