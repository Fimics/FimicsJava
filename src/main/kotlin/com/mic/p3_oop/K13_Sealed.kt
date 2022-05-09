package com.mic.p3_oop

/*
    密封类（sealed class） 类似java 枚举 但有不同点
 */

//sealed是抽象的
sealed class Calculator {}

class Add : Calculator()
class Subtract : Calculator()
class Multiply : Calculator()

fun calculate(a: Int, b: Int, cal: Calculator) = when (cal) {
    is Add -> a + b
    is Subtract -> a - b
    is Multiply -> a * b
}


fun main() {
    println(calculate(1, 2, Add()))
    println(calculate(1, 2, Subtract()))
    println(calculate(1, 2, Multiply()))
}