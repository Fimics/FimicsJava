package com.mic.p3_oop

// 对象表达式（object expression）
// Java当中匿名内部类在很多场景下都得到了大量使用
// Kotlin的对象表达式就是为了解决匿名内部类的一些缺陷而产生的

/*
    1. 匿名内部类是没有名字的类
    2. 匿名内部类一定是继承了某个父类，或是实现了某个接口
    3. Java运行时会将该匿名内部类当做它所实现的接口或是所继承的父类来看待
 */

/*
    对象表达式的格式：

    object [: 若干个父类型，中间用逗号分隔] {

    }
 */

interface MyInterface {
    fun myPrint(i: Int)
}

abstract class MyAbstractClass {
    abstract val age: Int

    abstract fun printMyAbstractClassInfo()
}

fun main() {
    var myObject = object: MyInterface {
        override fun myPrint(i: Int) {
            println("i的值是$i")
        }
    }

    myObject.myPrint(100)

    println("-------")

    var myObject2 = object {
        init {
            println("初始化块执行")
        }

        var myProperty = "hello world"

        fun myMethod() = "myMethod()"
    }

    println(myObject2.myProperty)
    println(myObject2.myMethod())

    println("-------")

    var myObject3 = object: MyInterface, MyAbstractClass() {
        override fun myPrint(i: Int) {
            println("i的值是$i")
        }

        override val age: Int
            get() = 30

        override fun printMyAbstractClassInfo() {
            println("printMyAbstractClassInfo invoked")
        }
    }

    myObject3.myPrint(200)
    println(myObject3.age)
    myObject3.printMyAbstractClassInfo()
}








