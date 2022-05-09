package com.mic.p2_function

/**
    构造方法引用（Constructor Reference）

    要求有两点：

    1. 函数对象的参数要与构造方法的参数保持一致（体现在参数个数与参数类型上）
    2. 函数对象的返回结果要与构造方法所在类的类型保持一致

 */

class B(val x: Int)

fun myMethod(factory: (x: Int) -> B) {
    val b: B = factory(3)
    println(b.x)
}

/**
 * 我们可以引用特定对象的一个实例方法
 *也可以引用特定对象的属性
 */

fun main() {
    myMethod(::B)

    val str = "abc"
    val getReference = str::get
    println(getReference(1))

    println("-------")

    val myProp = "test"::length
    println(myProp.get())

    println("-------")

    val myProp2 = String::length
    println(myProp2.get("test"))
}