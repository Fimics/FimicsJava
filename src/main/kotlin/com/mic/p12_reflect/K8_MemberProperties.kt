package com.mic.p12_reflect

import kotlin.reflect.KMutableProperty
import kotlin.reflect.full.memberProperties

class MyTestClass2(var a: String, val flag: Boolean, var age: Int) {}

class MyTestClassM {
    var name: String = "hello world"
}

class MyTestClass7 {
    var name: String = "hello world"
    var authorName: String = "tom"
}

fun main() {
    val myTestClass2 = MyTestClass2::class
    println(myTestClass2.memberProperties)

    val myTestClass6 = MyTestClassM::class
    var testClass6 = MyTestClassM()

    var variableToInvoke6 = myTestClass6.memberProperties.find { it.name == "name" }

    println(variableToInvoke6?.get(testClass6))
    println(variableToInvoke6?.call(testClass6))

    println("MyTestClass7")

    val myTestClass7 = MyTestClass7::class
    var testClass7 = MyTestClass7()

    var variableToInvoke = myTestClass7.memberProperties.find { it.name == "name" }
    println(variableToInvoke?.get(testClass7))

    //KMutableProperty 先判读是否是可读写属性
    if (variableToInvoke is KMutableProperty<*>) {
        variableToInvoke.setter.call(testClass7, "welcome")
    }
    println(variableToInvoke?.get(testClass7))
}