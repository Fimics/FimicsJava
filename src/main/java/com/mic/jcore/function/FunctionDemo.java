package com.mic.jcore.function;

public class FunctionDemo {


    /**
     * output 3,4
     * 方法调用时，实参把它的值传递给对应方法的形参，同时内存空间中分配了形参空间，接着在方法内对形参空间进行操作。
     * 值传递类型：八种基本数据类型和String
     */
    public static void exchange(int a, int b) {
        int tmp = a;
        a = b;
        b = tmp;
    }


    /**
     * output 1
     * 我们将myClass作为实参传入方法的时候，JVM会新申请出一个空间作为形参空间，
     * 此时实参myClass和形参myClass指向同一个空间，这时对形参的指向发生改变，故不会影响实参的值。
     * 倘若，change方法中去掉new，那运行结果就必然为2了
     * @param myClass
     */
    private static void change(MyClass myClass) {
        myClass = new MyClass();
        myClass.val = 2;
    }

    public static class MyClass {
        int val = 1;
    }

    public static void main(String[] args) {
        int a = 3;
        int b = 4;
        exchange(a, b);
        System.out.println(a);
        System.out.println(b);

        MyClass myClass = new MyClass();
        change(myClass);
        System.out.println(myClass.val);
    }


}
