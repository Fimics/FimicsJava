package com.mic.p16_coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

/*
    协程是轻量级的
 */

fun main()= runBlocking {

    //repeat 重复创建5000个协程
    repeat(5000){
        launch { delay(1000)
        println("A")
        }
    }

    println("hello world")
    repeatThread()
}

fun repeatThread(){
    repeat(500){
        thread {
//            Thread.sleep(1000)
            println("A")
        }
    }

    println("thread")
}