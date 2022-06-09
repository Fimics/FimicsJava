package com.mic.core

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.Semaphore
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.sync.withPermit
import java.util.concurrent.atomic.AtomicInteger

/**
 * 并发与安全
 */

//1.
suspend fun badCaseSafe() {
    var count = 0
    List(1000) {
        GlobalScope.launch {
            count++
        }
    }.joinAll()

    println("count -> $count") //991 不是线程安全的，所以返回的不对
}

//2.
suspend fun add() {
    var count = AtomicInteger(0)
    List(1000) {
        GlobalScope.launch {
            count.incrementAndGet()
        }
    }.joinAll()

    println("count -> $count")
}

/**
 * 1·Channel：并发安全的消息通道，我们已经非常熟悉。
 * 2·Mutex：轻量级锁，它的lock和unlock从语义上与线程锁比较类似，之所以轻量是因为它在获取不到锁时不会阻塞线程而只是挂起等待锁的释放
 */

//3.mutex

suspend fun testMutex() {
    var count = 0;
    val mutex = Mutex()
    List(1000) {
        GlobalScope.launch {
            mutex.withLock {
                count++
            }
        }
    }.joinAll()
    println("count -> $count")
}

//4.·Semaphore：轻量级信号量，信号量可以有多个，协程在获取到信号量后即可执行并发操作。当Semaphore的参数为1时，效果等价于Mutex，
//

suspend fun testSemaphore(){
    var count = 0;
    val semaphore = Semaphore(1)
    List(1000) {
        GlobalScope.launch {
            semaphore.withPermit {
                count++
            }
        }
    }.joinAll()
    println("count -> $count")
}

//5.避免访问外部可变状态
suspend fun testOuter(){
    val count =0
    val result = count+List(1000){
        GlobalScope.async { 1 }
    }.map {
        it.await()
    }.sum()
    println("count -> $result")
}


suspend fun main() {
//    badCaseSafe()
//    add()
//    testMutex();
//    testSemaphore()
    testOuter()
}