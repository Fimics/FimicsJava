package com.mic.reflect


import kotlin.reflect.jvm.javaField
import kotlin.reflect.jvm.javaGetter


class T(val x: Int)

fun main(args: Array<String>) {
    println(T::x.javaGetter)
    println(T::x.javaField)

    println("---------")

    println(T(10).javaClass)
    println(T(10).javaClass.kotlin)

    println(String.javaClass)
    println(String.javaClass.kotlin)
}