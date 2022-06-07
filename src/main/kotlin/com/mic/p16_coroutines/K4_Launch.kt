package com.mic.p16_coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


/*
    每一个协程构建器（包括runBlocking）都会向其代码块作用域中添加一个CoroutineScope实例。我们可以在该作用域中启动协程，而无需
    显式将其join到一起，这是因为外部协程（在下面的示例中就是runBlocking）会等待该作用域中的所有启动的协程全部完成后才会完成。
 */


/**
 * public fun CoroutineScope.launch(
 *context: CoroutineContext = EmptyCoroutineContext,
*start: CoroutineStart = CoroutineStart.DEFAULT,
*block: suspend CoroutineScope.() -> Unit
*): Job {
 *
 * 携程的启动模式-CoroutineStart
 * 1.DEFAULT：协程创建后，立即开始调度，在调度前如果协程被取消，其将直接进入取消响应的状态。·
 * 2.ATOMIC：协程创建后，立即开始调度，协程执行到第一个挂起点之前不响应取消。
 * 3·LAZY：只有协程被需要时，包括主动调用协程的start、join或者await等函数时才会开始调度，如果调度前就被取消，那么该协程将直接进入异常结束状态。
 * 4·UNDISPATCHED：协程创建后立即在当前函数调用栈中执行，直到遇到第一个真正挂起的点。
 *
 * 调度器
 *
 */

fun main(): Unit = runBlocking {
    //不加GlobalScope会等待launch里的代码执行完 主线程才会退出
    launch {
        delay(1000)
        println("kotlin coroutines")
    }

    println("hello")
}