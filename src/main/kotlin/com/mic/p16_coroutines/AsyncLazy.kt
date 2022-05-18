package com.mic.p16_coroutines

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/*
    关于async的延迟执行

    我们可以通过将async方法的start参数设置为CoroutineStart.LAZY来实现协程的延迟执行。
    在这种情况下，协程会在两种场景下去执行：调用Deferred的await方法，或是调用Job的start方法。

 */

fun main() = runBlocking {
    val elapsedTime = measureTimeMillis {
        val value1 = async(start = CoroutineStart.LAZY) { intValue1() }
        val value2 = async(start = CoroutineStart.LAZY) { intValue2() }

        println("hello world")

        Thread.sleep(6000)

        // 尝试注释掉如下两行代码
        value1.start()
        value2.start()

        val result1 = value1.await()
        val result2 = value2.await()

        println("$result1 + $result2 = ${result1 + result2}")
    }

    println("total time: $elapsedTime")
}


private suspend fun intValue1(): Int {
    delay(2000)
    return 15
}

private suspend fun intValue2(): Int {
    delay(3000)
    return 20
}