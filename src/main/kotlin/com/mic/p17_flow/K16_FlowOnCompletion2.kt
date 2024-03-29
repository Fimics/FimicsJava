package com.mic.p17_flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.runBlocking

/*
    类似于catch运算符，onCompletion只会看到来自于Flow上游的异常，但是它看不到Flow下游的异常。
 */

private fun myMethod(): Flow<Int> = (1..10).asFlow()

fun main() = runBlocking<Unit> {
    myMethod().onCompletion { cause -> println("Flow Completed with $cause") }
            .collect { value ->
                check(value <= 1) { "Collected $value" }
                println(value)
            }
}