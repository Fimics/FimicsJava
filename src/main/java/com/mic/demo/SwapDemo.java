package com.mic.demo;

public class SwapDemo {

    public static void main(String[] args) {

        int m = 1;
        int n= 2;
        swap(m,n);

        System.out.println("m="+m+"  n="+n);

        float a= 1.3f;
        double b = 1.3;
        double c = a;

        System.out.println(a==b);

    }

    private static void swap(int a ,int b){
        int tmp = 0;
        tmp = a;
        a = b;
        b = tmp;

        System.out.println("a="+a+"  b="+b);
    }
}
