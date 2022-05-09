package com.mic.p2_function

/**
    函数（方法）引用

    支持重载

    ::multiplyBy3表示函数类型 (Int) -> Int 的值
 */

val myReference: (Int) -> Int = ::multiplyBy3
val myReference2: (String) -> Int = ::multiplyBy3

val myReference3: String.(Int) -> Char = String::get

//它是名级别的函数，编译完位于MethodFefKt类里
fun multiplyBy3(x:Int):Int{
    return 3*x;
}

fun multiplyBy3(s:String):Int{
    return 10
}

fun main(){
    val values = listOf(1,2,3,4)
    println(values.map(::multiplyBy3))
    values.map { it-> multiplyBy3(it) }.forEach(::println)

    println("----")

    val values2 = listOf("a","b","c","d")
    values2.map(::multiplyBy3).forEach(::println)
}

