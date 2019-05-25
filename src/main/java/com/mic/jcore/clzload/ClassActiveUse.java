package com.mic.jcore.clzload;

/**
 * test class init
 * 主动使用
 * 1.new ,直接使用
 * 2.访问某个类或者接口的静态变量，或者对该静态变量进行赋值操作
 * 3.调用静态方法
 * 4.反射某个类
 * 5.初始化一个子类
 * 6.启动类，：java HelloWorld
 *
 * ----------------------------------------------
 *
 * 除了以上六个以外，其余的都是被动使用，不会导致类的初始化
 *
 *1.通过子类访问父类的static变量，不会导致子类的初始化
 *2.定义引用数组，不会初始化 Obj arrays = new Obj[10]
 *3.final修饰的常量会在变异期间放到常量池中，不会初始化类
 *4.final修饰的复杂类型，在编译期间无法计算得出，会初始化类 public static final int x = new Random().nextInt(100);
 *
 */
public class ClassActiveUse {

    public static void main(String[] args) {

    }
}


class Obj{

    static {
        System.out.println("Obj initialization..");
    }
}


