package com.mic.p12_reflect

import kotlin.reflect.full.createInstance
import kotlin.reflect.full.functions


class MyTestClass9(value: Int = 0) {
    fun printSomething() {}
    fun printNothing() {}
}

fun main() {
    var myTestClass9 = MyTestClass9::class
    var myObj = myTestClass9.createInstance()

    myTestClass9.functions.find { it.name == "printSomething" }?.call(myObj)
    myTestClass9.functions.find { it.name == "printNothing" }?.call(myObj)
}
