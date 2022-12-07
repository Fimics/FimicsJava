package com.mic.p12_reflect


class MyTestClass5(value: Int) {
    constructor(amount: Int, color: String): this(amount) {}
    constructor(amount: Int, full: Boolean): this(amount) {}
    fun printSomething() { println("something") }
}

fun main() {
    val myTestClass5 = MyTestClass5::class
    val constructors = myTestClass5.constructors
    println(myTestClass5)
    constructors.forEach { println(it) }
}