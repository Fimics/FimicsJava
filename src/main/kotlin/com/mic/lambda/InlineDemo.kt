package com.mic.lambda


/*
    内联函数（inline function）

 */

/**
 * 直接放到代码调用处，生成的字节码比较大
 */
inline fun myCalculate(a: Int, b: Int) = a + b

fun main(args: Array<String>) {
    println(myCalculate(1, 2))
}