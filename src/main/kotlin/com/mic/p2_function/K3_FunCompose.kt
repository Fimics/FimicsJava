package com.mic.p2_function

/*
    函数组合
 */

//f: (B)-> C  f函数输入B类型参数返回C类型结果
fun <A, B, C> myCompose(f: (B) -> C, g: (A) -> B): (A) -> C {
    return { x -> f(g(x)) }
}

fun isEven(x: Int) = 0 == x % 2

fun length(s: String) = s.length


fun main() {
    val evenLength = myCompose(::isEven, ::length)
    val strings = listOf("a", "ab", "abc", "abcd", "abcde")

    println(strings.filter(evenLength))
}