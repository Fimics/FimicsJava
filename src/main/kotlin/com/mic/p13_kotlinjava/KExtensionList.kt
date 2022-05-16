package com.mic.p13_kotlinjava

fun main() {
    val list = listOf<String>()
    println(list.myFilter())

    val list2 = listOf<Int>()
    println(list2.myFilter())
}

//被扩展的类当作第一个参数传到扩展函数里
fun List<String>.myFilter(): List<String> {
    return listOf("hello", "world")
}

@JvmName("myFilter2")
fun List<Int>.myFilter(): List<Int> {
    return listOf(1, 2)
}