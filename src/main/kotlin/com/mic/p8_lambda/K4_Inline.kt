package com.mic.p8_lambda


/*
    内联函数（inline function）连接到一起

 */

/**
 * 直接放到代码调用处，生成的字节码比较大
 */
inline fun myCalculate(a: Int, b: Int) = a + b

fun main() {
    println(myCalculate(1, 2))
}