package com.mic.p16_coroutines

import kotlin.concurrent.thread

fun main(){
    //kotlin的方式创建线程
    thread {
        Thread.sleep(1000)
        println("Kotlin Coroutines")
    }
    println("Hello")
    Thread.sleep(200)
    println("World")
}