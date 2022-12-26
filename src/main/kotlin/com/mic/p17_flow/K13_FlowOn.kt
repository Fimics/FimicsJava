package com.mic.p17_flow

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.runBlocking


private fun log(msg: String) = println("[${Thread.currentThread().name}], $msg")

private fun myMethod(): Flow<Int> = flow {
    for (i in 1..4) {
        Thread.sleep(100)
        log("Emit: $i")
        emit(i)
    }
}.flowOn(Dispatchers.Default)


fun main() = runBlocking {
    myMethod().collect { value ->
        log("Collected: $value")
    }
}