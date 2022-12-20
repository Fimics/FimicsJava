package com.mic.p16_coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**

 * 3.CoroutineScope
 *       1.可以理解为协程本身，包含了CoroutineContext
 *       2.除去不同的协程构建器所提供的协程作用域（coroutine scope）外，我们还可以通过coroutineScope builder来声明自己的协程作用域。
 *         该构建器会创建一个协程作用域，并且会等待所有启动的子协程全部完成后自身才会完成
 *       3. coroutineScope是挂起函数；也就是说，如果其中的协程挂起，那么coroutineScope函数也会挂起。这样，创建coroutineScope的外层
 *         函数就可以继续在同一个线程中执行了，该线程会『逃离』coroutineScope之外，并且可以做其他一些事情。
 *
 * 4.CoroutineContext
 *      协程上下文，是一些元素的集合，主要包括Job 和CoroutineDispatcher元素，可以代表一个协程场景
 *
 * 5.CoroutineDispatcher
 *      1.调度器，决定协程所在的线程或线程池，它可以指定协程运行于哪个线程或线程池， 如果不指定 就运行于当前线程
 *      2.Dispatchers.Default
 *      4.Dispatchers.IO
 *      5.Dispatchers.Main
 *      6.Unconfined 不指定线程池
 *
 * 6.launch
 *       launch函数如果不指定CoroutineDispatcher 或者没有其他的ContinuationInterceptor,默认的协程调度器就是Dispatcher.Default,
 *       Default是一个协程调度器，其指定的线程为共有线程持，线程数量至少为2 ，最大与CPU数量相同
 *
 * 7.Job & Deferred
 *    1.job 任务封装了协程中需要执行的代码逻辑，job可以取消并且有简单的生命周期，它有三种状态,launch也会返回一个job对象但是没有返回值
 *    2.Deferred  ，Deferred 值是一个非阻塞可取消的future,它是一个带有结果的job
 *
 * 8.CoroutineScope.Launch{}
 *     是常用的 CoroutineBuilders 不阻塞当前线程，在后台创建一个新协程，也可以指定协程调度器
 *
 *9.runBlocking{}
 *     1.创建一个新的协程同时阻塞当前线程，直到协程结束，这个不应该在协程中使用，主要是为main函数和测试使用
 *     2.runBlocking与coroutineScope之间的主要差别在于，后者在等待所有子协程完成其任务时并不会阻塞当前的线程。
 *     3. runBlocking并非挂起函数；也就是说，调用它的线程会一直位于该函数之中，直到协程执行完毕为止。
 *
 *10.withContext{}
 *     不会创建新的协程，在指定协程上运行挂起代码块，并挂起该协程直到代码运行完成
 *
 *11.async{}
 *    CoroutineScope.async{}可以实现与 launcher builder一样的效果，在后台创建一个新的协程，唯一的区别是它有返回值
 *    因为CoroutineScope.async{} 返回的是一个Deferred类型
 */

/**
 * 1.CoroutineContext
 *   协程上下文是协程中的重要概念，它管理了协程的生命周期，线程调度，异常处理等功能
 *
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