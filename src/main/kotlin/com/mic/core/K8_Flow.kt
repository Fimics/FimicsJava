package com.mic.core

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

//1 不能使用Delay()
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

//3.flow异常处理
val intFlowEx = flow<Int> {
    (1..3).forEach {
        emit(it)
        throw java.lang.ArithmeticException("Div 0")
    }
}.onCompletion {
    println("finish")
}.catch { cause ->
    println("caught error:$cause")
}

//4.命令式异常处理
val intFlowEx1 = flow<Int> {
    try {
        (1..3).forEach {
            emit(it)
            throw java.lang.ArithmeticException("Div 0")
        }
    } catch (e: java.lang.Exception) {
        println("caught error: $e")
        emit(10)
    } finally {
        println("finally")
    }

}

//5.分离flow的消费和触发
fun createFlow() = flow<Int> {
    (1..3).forEach {
        emit(it)
        delay(100)
    }
}.onEach {
    println("element -> $it")
}

//6.Flow的取消 ， Flow的消费依赖于collect这样的末端操作符，而它们双必须在携程中调用 ，因此Flow的取消主要依赖于末端操作符所在的携程状态，
val job = GlobalScope.launch {
    val intFlow6 = flow<Int> {
        (1..3).forEach {
            delay(1000)
            emit(it)
        }
    }.onEach {
        println("element6 -> $it")
    }
    intFlow6.collect({ println(it) })
}

//7.flow{...}这种形式的创建方式，不过在这当中无法随意切换调度器，这是因为emit函数不是线程安全的
//想要在生成元素时切换调度器，就必须使用channelFlow函数来创建Flow：
val channelFlow = channelFlow<Int> {
    (1..3).forEach {
        send(it)
    }
    withContext(Dispatchers.IO) {
        send(20)
    }
}

//7.集合框架创建flow
fun flowCreate() {
    listOf<Int>(1, 2, 3, 4).asFlow()
    setOf<Int>(1, 2, 4).asFlow()
    flowOf(1, 2, 4)
}

/**
 * 8.背压问题
 * 只要是响应式编程，就一定会有背压问题，先来看看背压究竟是什么。
 * 背压问题在生产者的生产速率高于消费者的处理速率的情况下出现。为了保证数据不丢失，我们也会考虑添加缓冲来缓解背压问题，
 */

fun flowBuffer() {
    flow<Int> {
        List(100) {
            emit(it)
        }
    }.buffer()
}

//8.1使用conflate解决背压问题  第一种是conflate。与Channel的Conflate模式一致，新数据会覆盖老数据，例如代码清单648所示。
suspend fun flowConflate() {
    flow<Int> {
        List(100) {
            emit(it)
        }
    }.conflate()
        .collect {
            println("Collecting $it")
            delay(100)
            println("$it collected")
        }
}

//8.2 第二种是collectLatest。顾名思义，其只处理最新的数据。这看上去似乎与conflate没有区别，
// 其实区别很大：collectLatest并不会直接用新数据覆盖老数据，而是每一个数据都会被处理，只不过如果前一个还没被处理完后一个就来了的话，
// 处理前一个数据的逻辑就会被取消。

//前面的Collecting输出了0~99的所有结果，而collected却只有99，因为后面的数据到达时，处理上一个数据的操作正好被挂起了
// （请注意delay(100)）。除collectLatest之外，还有mapLatest、flatMapLatest等，因为作用类似，故不再重复。


//9.Flow的变换

suspend fun flowChange() {

    //9.1
    flow<Int> {
        List(5) {
            emit(it)
        }.map {
            it
        }
    }

    //9.2
    flow<Int> {
        List(5) {
            emit(it)
        }.map {
            flow<Int> {
                List(5) { emit(it) }
            }
        }
    }

    //9.3
    flow {
        List(5) {
            emit(it)
        }
    }.map {
        flow {
            List(it) { emit(it) }
        }
    }.flattenConcat()
        .collect { println(it) }


}

suspend fun flowCollectLatest() {
    flow<Int> {
        List(100) {
            emit(it)
        }
    }.collectLatest {
        println("Collecting $it")
        delay(100)
        println("$it collected")
    }
}


suspend fun main() {
    //1.
//    ints.iterator().forEach { println(it) }
    //2
//    GlobalScope.launch {
//        intFlow.flowOn(Dispatchers.Main).collect{
//            println(it)
//        }

//        intFlowEx.collect()
//          intFlowEx1.collect()
    //5
//        createFlow().collect()
//}.join()

    //6
//    delay(2500)
//    job.cancelAndJoin()

    //8.1
//    flowConflate()
    //8.2
    flowCollectLatest()

}