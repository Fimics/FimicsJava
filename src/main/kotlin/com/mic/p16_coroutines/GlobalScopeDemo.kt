package com.mic.p16_coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/*
    全局协程类似于守护线程（daemon thread）

    使用GlobalScope启动的活动协程并不会保持进程的生命，他们就像是守护线程一样
 */

fun main(){
    //GlobalScope 可理解为协程本身，，它不阻塞当前线程，在后台创建一个新协程，也可以指定协程调度器
    GlobalScope.launch(Dispatchers.IO) {
        //delay 会阻塞当前协程执行，但不会阻塞当前线程执行
        delay(1000)
        println("kotlin coroutines")
    }

    println("hello")
    Thread.sleep(1500)
    println("world")
}