package com.mic.p13_kotlinjava

class MyClass1 {

    val a: Int
        //解决方法冲突
        @JvmName("getAValue")
        get() = 20

    fun getA() = 30
}

fun main() {
    val myClass = MyClass1()

    println(myClass.getA())
    println(myClass.a)
}