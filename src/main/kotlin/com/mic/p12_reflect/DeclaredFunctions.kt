package com.mic.p12_reflect

import kotlin.reflect.full.createInstance
import kotlin.reflect.full.declaredFunctions


class MyTestClass11 {

    fun method(message: String) {
        println("执行带String参数的方法： $message")
    }

    fun method(message: String, price: Double) {
        println("执行带String, Double参数的方法: $message $price")
    }
}

fun main() {
    val clazz = MyTestClass11::class
    val instance = clazz.createInstance()

    val funs = clazz.declaredFunctions

    for (f in funs) {
        if (f.parameters.size == 3) {
            f.call(instance, "Ruby", 23.4)
        }

        if (f.parameters.size == 2) {
            f.call(instance, "Flutter")
        }
    }
}