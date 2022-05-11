package com.mic.p5_generics;

// use-site variance(type projection)，类型投影


// 数组的浅拷贝
fun copy(from: Array<out Any>, to: Array<Any>) {
//    assertTrue(from.size == to.size)

    for (i in from.indices) {
        to[i] = from[i]
    }
}

fun main() {
    val from: Array<Int> = arrayOf(1, 2, 3, 4)
    val to: Array<Any> = Array<Any>(4, {"hello" + it})

    for (item in to) {
        println(item)
    }

    copy(from, to)

    println("************")

    val array: Array<String> = Array<String>(4, {_ -> "hello"})

    for (item in array) {
        println(item)
    }

    setValue(array, 1, "world")

    println("************")

    for (item in array) {
        println(item)
    }

    println("************")

    val array2: Array<Any> = Array<Any>(4, {it -> "hello " + it})

    for (item in array2) {
        println(item)
    }

    println("************")

    setValue(array2, 1, "world")

    for (item in array2) {
        println(item)
    }
}

fun setValue(to: Array<in String>, index: Int, value: String) {
    to[index] = value
}
