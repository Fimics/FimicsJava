package com.mic.core

import kotlin.coroutines.*

fun main() {

}

//1.创建协程
val continuation3= suspend {
    println("in continuation")
    5
}.startCoroutine(object :Continuation<Int>{
    override val context: CoroutineContext = LogInterceptor()

    override fun resumeWith(result: Result<Int>) {
        println("Coroutine End: $result")
    }

})

class LogInterceptor : ContinuationInterceptor {

    override val key= ContinuationInterceptor

    override fun <T> interceptContinuation(continuation: Continuation<T>) = LogContinuation(continuation)
}

class LogContinuation<T>(private val continuation: Continuation<T>) : Continuation<T> by continuation {
    override fun resumeWith(result: Result<T>) {
        println("before resume With:$result")
        continuation.resumeWith(result)
        println("after resume With.")
    }
}