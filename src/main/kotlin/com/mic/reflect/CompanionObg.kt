package com.mic.reflect

import kotlin.reflect.full.companionObject


class MyTestClass8 {

    companion object {
        fun method() {
            println("hello world")
        }
    }
}

fun main(args: Array<String>) {
    var myTestClass8 = MyTestClass8::class
    var companionObj = myTestClass8.companionObject

    println(companionObj)

    MyTestClass8.method()
}