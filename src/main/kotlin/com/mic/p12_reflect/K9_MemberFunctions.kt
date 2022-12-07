package com.mic.p12_reflect


import kotlin.reflect.full.memberFunctions

class MyTestClass4 {

    fun printSomething() {}
}

fun main() {
    val myTestClass3 = MyTestClass4::class
    println(myTestClass3.memberFunctions)
}