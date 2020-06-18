package com.mic.reflect


import kotlin.reflect.full.memberFunctions

class MyTestClass4 {

    fun printSomething() {
        println("something")
    }

    fun printNothing() {
        println("")
    }
}

fun main(args: Array<String>) {
    val myTestClass3 = MyTestClass4::class
    println(myTestClass3.memberFunctions)
}