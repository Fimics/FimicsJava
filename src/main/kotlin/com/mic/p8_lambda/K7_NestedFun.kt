package com.mic.p8_lambda

/*
    匿名函数
 */


fun main() {
    fun(x: Int, y: Int) = x + y

    fun(x: Int, y: Int): Int {
        return x + y
    }

    val strings = arrayOf("hello", "world", "bye")

    strings.filter(fun(item): Boolean = item.length > 3).forEach(fun(item){ println(item)})
}