package com.mic.p17_flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

/*
    Flow Exception
 */

private fun myMethod(): Flow<Int> = flow {
    for (i in 1..3) {
        println("Emitting $i")
        emit(i)
    }
}

fun main() = runBlocking<Unit> {
    try {
        myMethod().collect { value ->
            println(value)
            check(value <= 1) {
                "Collected $value"
            }
        }
    } catch (e: Throwable) {
        println("Caught $e")
    }
}