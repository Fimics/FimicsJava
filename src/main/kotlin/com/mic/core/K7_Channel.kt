package com.mic.core

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch

//1.channel(热流数据) 它是一个并发安全的队列，可以用来连接携程，实现不同的携程通信

val channel = Channel<Int>()

val producer = GlobalScope.launch {
    var i = 0
    while (true) {
        delay(1000)
        channel.send(i++)
    }
}

val consumer = GlobalScope.launch {
    //1.
//    while (true){
//        val element = channel.receive()
//        println("element ->$element")
//    }

    //2.
//    val iterator= channel.iterator()
//    while (iterator.hasNext()){
//        val element = iterator.next()
//        println("element -->$element")
//    }

    //3.

    for (e in channel) {
        println("e  ->$e")
    }
    channel.close()
}


//2.
val receiveChannel: ReceiveChannel<Int> = GlobalScope.produce {
    repeat(100) {
        delay(1000)
        send(it)
    }
}

val sendChannel: SendChannel<Int> = GlobalScope.actor {
    while (true) {
        val element = receive()
        println("element ->$element")
    }
}


suspend fun main() {

    //1.
//    producer.join()
//    consumer.join()
    //2.
//    receiveChannel.receive()
//    sendChannel.send(1)

//3.
    val broadcastChannel = BroadcastChannel<Int>(Channel.BUFFERED)
//val receiveChannel1 = broadcastChannel.openSubscription()
    val producer1 = GlobalScope.launch {
        List(3) {
            delay(100)
            broadcastChannel.send(it)
        }
        broadcastChannel.close()
    }

    List(3) { index ->
        GlobalScope.launch {
            val receiveChannel = broadcastChannel.openSubscription()
            for (i in receiveChannel) {
                println("[#index] received: $i")
            }
        }
    }.joinAll()
}