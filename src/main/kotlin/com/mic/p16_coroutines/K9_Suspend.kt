package com.mic.p16_coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
    被suspend关键字所修饰的函数叫做挂起函数

    挂起函数（suspending function）

    挂起函数可以像普通函数一样用在协程当中，不过它的一个特性在于可以使用其他的挂起函数

    重点：挂起函数只能用在协程或是另外一个挂起函数中
 */

fun main() = runBlocking {
    launch {
        world()
    }

    println("Welcome")
}

suspend fun hello() {
    delay(4000)
    println("Hello World")
}

suspend fun world() {
    hello()
}
