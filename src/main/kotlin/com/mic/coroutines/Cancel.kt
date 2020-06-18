package com.mic.coroutines

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/*
    关于父子协程的异常与取消问题

    协程的取消总是会沿着协程层次体系向上进行传播
 */

fun main() = runBlocking<Unit> {
    try {
        failureComputation()
    } finally {
        println("Computation failed")
    }
}


private suspend fun failureComputation(): Int = coroutineScope {
    val value1 = async<Int> {
        try {
            delay(9000000)
            50
        } finally {
            println("value1 was cancelled")
        }
    }

    val value2 = async<Int> {
        Thread.sleep(2000)
        println("value2 throws an exception")

        throw Exception()
    }

    value1.await() + value2.await()
}