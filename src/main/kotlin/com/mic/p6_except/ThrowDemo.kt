package com.mic.p6_except

import java.io.IOException

// throw在Kotlin中是个表达式，这样我们可以将throw作为Elvis表达式的一部分
// throw表达式的类型是一种特殊的类型：Nothing。
// 在自己的代码中，可以使用Nothing来标记永远不会返回的函数
fun main() {
    val str: String? = "a"
    val str2 = str ?: throw IllegalArgumentException("值不能为空")

    println(str2)

    println("----------")

    val str3 = str ?: myMethod("hello")
    println(str3)

    println("----------")

    var s = null
    println(s is Nothing?)

    var s2 = listOf(null)
    println(s2 is List<Nothing?>)
}

fun myMethod(message: String): Nothing {
    throw IllegalArgumentException(message)
}

@Throws(IOException::class)
fun testException(){

}