package com.mic.p17_flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking


private fun myMethod(): Flow<String> =
        flow {
            for (i in 1..3) {
                println("Emitting $i")
                emit(i)
            }
        }.map { value ->
            check(value <= 1) { "Crash on $value" }
            "string $value"
        }

fun main() = runBlocking<Unit> {
    try {
        myMethod().collect { println(it) }
    } catch (e: Throwable) {
        println("Caught $e")
    }
}