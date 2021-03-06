package com.mic.reflect


class MyTestClass5(value: Int) {

    constructor(amount: Int, color: String): this(amount) {
        println("secondary constructor")
    }

    constructor(amount: Int, full: Boolean): this(amount) {
        println("secondary constructor")
    }

    fun printSomething() {
        println("something")
    }
}

fun main(args: Array<String>) {
    val myTestClass5 = MyTestClass5::class
    val constructors = myTestClass5.constructors

    println(constructors)
}