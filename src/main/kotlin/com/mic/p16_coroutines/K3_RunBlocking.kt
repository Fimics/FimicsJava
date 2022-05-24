package com.mic.p16_coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    GlobalScope.launch {
        delay(1000)
        println("Kotlin Coroutines")
    }

    println("Hello")

    //创建新协程同时阻塞当前线程，直到协程线束，，这个不应该在协程中使用，主要是main函数和测试设计
    runBlocking {
        delay(2000)
    }

    println("World")

    println("runBlockingTest")
    runBlockingTest()
}

fun runBlockingTest()= runBlocking {
    GlobalScope.launch {
        delay(1000)
        println("Kotlin Coroutines")
    }

    println("Hello")

    delay(2000)

    println("World")
}