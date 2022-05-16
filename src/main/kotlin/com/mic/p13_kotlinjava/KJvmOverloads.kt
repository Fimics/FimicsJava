package com.mic.p13_kotlinjava


/*
    MyClass2(int x, String y)
    MyClass2(int x)
 */


class MyClass3 @JvmOverloads constructor(x: Int, y: String = "hello") {

    fun myMethod(a: Int, b: String, c: Int = 2) {
        println("a: $a, b: $b, c: $c")
    }
}