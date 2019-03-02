package com.mic.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

@FunctionalInterface
interface OnClick {

    void onClick();

    String toString();

}


public class  FunctionalDemo{

    public static void main(String[] args) {
          FunctionalDemo demo = new FunctionalDemo();
          demo.onClick(()-> {
                  System.out.println("click");});

          //Lambda 到底是什么类型，必须给出上下文环境
          OnClick onClick =()->{
              System.out.println("hello");
          };

        System.out.println(onClick.getClass());
        System.out.println(onClick.getClass().getSuperclass());
        System.out.println(onClick.getClass().getInterfaces());

        new Thread(()-> System.out.println("thread")).start();

        List<String> list = Arrays.asList("hello","world","java");
        List<String> upperList = new ArrayList<>();

        list.forEach(l-> System.out.println(l.toUpperCase()));



    }

    public void onClick(OnClick click){
        click.onClick();
    }
}
