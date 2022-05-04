package com.mic.p1_base

//相当于 if else ,swith case
fun main() {
    println(myPrint("hello"))
    println(myPrint("world"))
    println(myPrint("test"))

    println("-------")

    println(myPrint2("test"))

    println("-------")

    var a = 5

    //when(a) 要包括所有的可能性，不然报错
    var result = when (a) {
        1 -> {
            println("a = 1")
            10
        }
        2 -> {
            println("a = 2")
            20
        }
        3, 4, 5 -> {
            println("a = 3 or 4 or 5")
            30
        }
        //6..10 是闭区间包括 6，7，8，9，10
        in 6..10 -> {
            println("a is between 6 and 10")
            40
        }
        else -> {
            println("a is other value")
            50
        }
    }

    println(result)

}

fun myPrint(str: String): String {
    return when (str) {
        "hello" -> "HELLO"
        "world" -> "WORLD"
        "hello world" -> "HELLO WORLD"
        else -> "other input"
    }
}

fun myPrint2(str: String): String =
        when (str) {
            "hello" -> "HELLO"
            "world" -> "WORLD"
            "hello world" -> "HELLO WORLD"
            else -> "other input"
        }