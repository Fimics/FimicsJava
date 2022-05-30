package com.mic.p17_flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking

/*
    限定数量的中间操作

 */

fun myNumbers(): Flow<Int> = flow {
    try {
        emit(1)
        emit(2)
        println("hello world")
        emit(3)
    } catch (ex: Exception) {
        println(ex)
    } finally {
        println("finally")
    }
}

//take(n) 前n个元素
fun main() = runBlocking {
    myNumbers().take(1).collect { println(it) }
}