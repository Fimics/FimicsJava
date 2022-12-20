package com.mic.coroutine

import kotlinx.coroutines.delay
import kotlin.coroutines.*


fun main() {
    launchCoroutine(ProducerScope<Int>()){
        println("in coroutine start")
        produce(100)
        delay(100)
        produce(200)
        println("in coroutine end ")
    }
}

//@RestrictsSuspension  加了该注解无法调用外部挂起函数
class ProducerScope<T>{
    suspend fun produce(value:T){
        println(" produce value ->$value")
    }
}

fun <R,T> launchCoroutine(receiver:R,block:suspend R.()->T){
    block.startCoroutine(receiver,object :Continuation<T>{
        override val context: CoroutineContext=EmptyCoroutineContext

        override fun resumeWith(result: Result<T>) {
            println("coroutine edn :${result.getOrNull()}")
        }
    })
}