package com.mic.p16_coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
    每一个协程构建器（包括runBlocking）都会向其代码块作用域中添加一个CoroutineScope实例。我们可以在该作用域中启动协程，而无需
    显式将其join到一起，这是因为外部协程（在下面的示例中就是runBlocking）会等待该作用域中的所有启动的协程全部完成后才会完成。
 */

fun main()= runBlocking {
    val job = GlobalScope.launch {
        delay(1000)
        println("kotlin coroutines")
    }

    println("hello")
    //等待job的任务执行完，主线程才会往下执行
    job.join()
    println("world")
}