package com.mic.p16_coroutines


import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
    除去不同的协程构建器所提供的协程作用域（coroutine scope）外，我们还可以通过coroutineScope builder来声明自己的协程作用域。
    该构建器会创建一个协程作用域，并且会等待所有启动的子协程全部完成后自身才会完成。

    runBlocking与coroutineScope之间的主要差别在于，后者在等待所有子协程完成其任务时并不会阻塞当前的线程。

    1. runBlocking并非挂起函数；也就是说，调用它的线程会一直位于该函数之中，直到协程执行完毕为止。
    2. coroutineScope是挂起函数；也就是说，如果其中的协程挂起，那么coroutineScope函数也会挂起。这样，创建coroutineScope的外层
       函数就可以继续在同一个线程中执行了，该线程会『逃离』coroutineScope之外，并且可以做其他一些事情。

 */

fun main() = runBlocking {
    launch {
        delay(1000)
        println("my job1")
    }

    println("person")

    coroutineScope {
        launch {
            delay(20000)
            println("my job2")
        }

        delay(5000)
        println("hello world")
    }

    println("welcome")
}
