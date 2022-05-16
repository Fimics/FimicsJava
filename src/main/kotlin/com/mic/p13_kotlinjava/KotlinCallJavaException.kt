package com.mic.p13_kotlinjava

import com.mic.kotlin.MyException

fun main() {
    val myException = MyException()
//    myException.myMethod()

    println("------------")

    val clazz = MyException()::class.java
    println(clazz)

    println("------------")

    println(MyException().javaClass)
}