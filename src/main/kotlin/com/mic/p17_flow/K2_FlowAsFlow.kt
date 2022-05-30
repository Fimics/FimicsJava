package com.mic.p17_flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.runBlocking

/**
 *flow介绍
 *https://blog.csdn.net/zx_android/article/details/122744370?spm=1001.2014.3001.5502
    *1. 挂起函数可以异步返回单个值，那如何异步多次返回多个值呢？使用flow，
 *
 *
 * 2.flow的特点：
     *2.1flow{…}块中的代码可以挂起
     *2.2使用flow，suspend修饰符可以省略
     *2.3流使用emit函数发射值
     *2.4流使用collect的函数收集值
     *2.5flow类似冷流，flow中代码直到流被收集(调用collect)的时候才运行，类似lazy，什么时候用，什么时候执行。
     *2.6流的连续性：流收集都是按顺序收集的
     *2.7flowOn可更改流发射的上下文，即可以指定在主线程或子线程中执行
     *2.8与之相对的是热流，我们即将介绍的 StateFlow 和 SharedFlow 是热流，在垃圾回收之前，都是存在内存之中，并且处于活跃状态的
 */

private fun myMethod(): Flow<Int> = (1..10).asFlow()


fun main() = runBlocking<Unit> {
    try {
        myMethod().collect { println(it) }
    } finally {
        println("finally")
    }
}