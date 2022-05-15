package com.mic.p12_reflect

import kotlin.reflect.full.functions

class MyTestClass6 {

    fun printSomething(name: String) {
        println("something: $name")
    }

    fun printNothing() {
        println("nothing")
    }
}

fun main() {
    val myTestClass6 = MyTestClass6::class
    val testClass6 = MyTestClass6()

    //functionToInvoke KFunction对象
    var functionToInvoke = myTestClass6.functions.find { it.name == "printNothing" }
    functionToInvoke?.call(testClass6)

    var funToInvoke = myTestClass6.functions.find { it.name == "printSomething" }
    funToInvoke?.call(testClass6, "hello world")
}