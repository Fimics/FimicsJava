package com.mic.core

import jdk.nashorn.internal.ir.Block
import kotlinx.coroutines.delay
import kotlin.coroutines.*

//1.创建协程
val continuation= suspend {
    println("in continuation")
    5
}.createCoroutine(object :Continuation<Int>{
    override val context: CoroutineContext=EmptyCoroutineContext

    override fun resumeWith(result: Result<Int>) {
        println("Coroutine End: $result")
    }

})


//2.创建并启动协程
val continuation2= suspend {
    println("in continuation")
    5
}.startCoroutine(object :Continuation<Int>{
    override val context: CoroutineContext=EmptyCoroutineContext

    override fun resumeWith(result: Result<Int>) {
        println("Coroutine End: $result")
    }

})


//3.协程体的Receiver

fun<R,T> launchCoroutine(receiver:R,block: suspend R.()->T){
    block.startCoroutine(receiver,object :Continuation<T>{
        override val context: CoroutineContext
            get() = EmptyCoroutineContext

        override fun resumeWith(result: Result<T>) {
            println("协程体的Receiver resumeWith")
        }
    })
}

//3.使用时首先chuangjain一个作用域，ProducerScope 用来模拟一个生成器协程的作用域，再使用它来创建协程

class ProducerScope<T>{
    suspend fun produce(value:T){
        println(value)
    }
}

//3.
fun callLaunchCoroutine(){
    launchCoroutine(ProducerScope<Int>()){
        println("in coroutine.")
        produce(1024)
//        delay(2000)
        produce(2048)
    }
}

/**
 * 4.挂起:
 * 挂起其实就是程序执行流程发生异步调用时，当前流程的执行状态进入等待状态，
 *注注意，挂起函数不一定真的会挂起，只是提供了挂起条件，那什么情况下才会真正的挂起？
 *
 * 5.挂起点
 *   挂起函数的调用处称为挂起点，挂起点如果出现异步调用，那么当前携程就被挂起，
 *   直到对应的Continuation的resume函数被调用才会恢复执行
 *
 *  6.CPS变换
 *
 */






fun main() {
    //我们已经知道如何创建协程，那么协程要如何运行呢？调用continuation.resume(Unit)之后，协程体会立即开始执行。
//    continuation.resume(Unit)

    //3.
    callLaunchCoroutine()
}