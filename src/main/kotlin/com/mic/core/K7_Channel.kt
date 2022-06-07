package com.mic.core

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

//1.channel 它是一个并发安全的队列，可以用来连接携程，实现不同的携程通信

val channel = Channel<Int>()

val producer = GlobalScope.launch {
    var i = 0
    while (true){
        delay(1000)
        channel.send(i++)
    }
}

val consumer = GlobalScope.launch {
    while (true){
        val element = channel.receive()
        println("element ->$element")
    }
}

suspend fun main() {

    producer.join()
    consumer.join()
}