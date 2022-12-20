package com.mic.coroutine

import kotlin.coroutines.*

class LogInterceptor : ContinuationInterceptor {
    override val key = ContinuationInterceptor
    override fun <T> interceptContinuation(continuation: Continuation<T>)
            = LogContinuation(continuation)
}

class LogContinuation<Int>(private val continuation: Continuation<Int>)
    : Continuation<Int> by continuation {
    override fun resumeWith(result: Result<Int>) {
        println("before resumeWith: ${result.getOrNull()}")
        continuation.resumeWith(result)
        println("after resumeWith.${result.getOrNull()}")
    }
}

suspend fun suspendFunc02(v1:String,v2:String):Int{
    return v1.length+v2.length
}

fun main() {
    suspend {
        suspendFunc02("Hello", "Kotlin")
//        suspendFunc02("Hello", "Coroutine")
    }.startCoroutine(object : Continuation<Int> {
        override val context = LogInterceptor()
        override fun resumeWith(result: Result<Int>) {
            println("this string length= ${result.getOrThrow()}")
        }
    })
}