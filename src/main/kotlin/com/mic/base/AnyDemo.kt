package com.mic.base

fun main() {
    println(convert2Uppercase("hello world"))
    println(convert2Uppercase(23))
}

//Any 代表任意类型 相当于java中的Object
fun convert2Uppercase(str: Any): String? {
    if(str is String) {
        return str.toUpperCase()
    }

    val a = arrayOf(1,2,3,4,5)
    hello(1,2,4)
    return null
}

fun hello(vararg  a:Int){
    for (i in a ){
        println(i)
    }
}