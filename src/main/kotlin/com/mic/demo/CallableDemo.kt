package com.mic.demo

import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.Future
import java.util.concurrent.ThreadLocalRandom

class CallableDemo:Callable<Int>{
    override fun call(): Int {
        return ThreadLocalRandom.current().nextInt()
    }
}

fun main() {
    val callable = CallableDemo()
    val executor=Executors.newFixedThreadPool(10)
    val future:Future<Int> = executor.submit(callable)
    val value = future.get()
    println("value==$value")
}
