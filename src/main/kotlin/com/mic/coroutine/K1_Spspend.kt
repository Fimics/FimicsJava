package com.mic.coroutine

import java.util.concurrent.Executors
import kotlin.coroutines.*


fun main() {
    println("main start")
    suspend {
        println("start")
        val value = doLogin()
        println("value ->$value")
        println("end")
        5
    }.startCoroutine(object : Continuation<Int> {
        override val context: CoroutineContext
            get() = EmptyCoroutineContext

        override fun resumeWith(result: Result<Int>) {
            println("result = ${result.getOrNull()}")
        }
    })
    println("main end")
}

suspend fun doLogin() = suspendCoroutine<Int> { continuation ->
    val threadGroup = ThreadGroup("thread-doLogin")
    val threadExecutor = Executors.newSingleThreadExecutor {
        Thread(threadGroup, it, "thread")
    }
    threadExecutor.submit {
        Thread.sleep(2000)
        continuation.resume(5)
    }
}