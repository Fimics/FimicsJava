package com.mic.coroutine.channel

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main() = runBlocking{
    channelTest()
}


private suspend fun channelTest(){
    val channel = Channel<Int>()

    val producer = GlobalScope.launch {
        var i =0
        while (true){
            delay(1000)
            println("send :$i")
            channel.send(i)
            i++
        }
    }

    val consumer = GlobalScope.launch {
        while (true){
            val element = channel.receive()
            println("receive : $element")
        }
    }

    producer.join()
    consumer.join()
}