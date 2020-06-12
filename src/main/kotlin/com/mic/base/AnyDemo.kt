package com.mic.base

fun main(args: Array<String>) {
    println(convert2Uppercase("hello world"))
    println(convert2Uppercase(23))
}

//Any 代表任意类型 相当于java中的Object
fun convert2Uppercase(str: Any): String? {
    if(str is String) {
        return str.toUpperCase()
    }

    return null
}