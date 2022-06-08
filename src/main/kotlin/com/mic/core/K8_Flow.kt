package com.mic.core

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.launch

//1
val ints = sequence<Int> {
    (1..3).forEach {
        yield(it)
    }
}


//2.所谓冷数据流，就是只有消费时才会生产的数据流，这一点与Channel正好相反，Channel的发送端并不依赖于接收端。
val intFlow = flow<Int> {
    (1..3).forEach {
        emit(it)
        delay(1000)
    }
}.flowOn(Dispatchers.IO)//flow的构造会在IO上执行


suspend fun main() {
//    ints.iterator().forEach { println(it) }
    //2
    GlobalScope.launch {
        intFlow.flowOn(Dispatchers.Main).collect{
            println(it)
        }
    }.join()
}