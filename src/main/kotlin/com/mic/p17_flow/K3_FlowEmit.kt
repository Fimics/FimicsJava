package com.mic.p17_flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
    如果返回List<String>结果类型，那么就表示只能一次性返回所有值。要想能够表示可以异步计算的流式的值，我们就可以使用
    Flow<String>类型，它非常类似于Sequence<String>类型，但其值是异步计算的。

    1. Flow构建器是通过flow来实现的。
    2. 位于flow{ }构建器中的代码是可以挂起的。
    3. myMethod方法无需再使用suspend标识符，值是通过emit函数来发射出来的
    4. Flow里面的值是通过collect方法来收集的

 */

private fun myMethod():Flow<Int> = flow {
    for (i in 1..4){
        delay(100)
        emit(i)
    }
}


//launch与myMethod并发的执行
fun main()= runBlocking<Unit>{
    launch {
        for (i in 1..4){
            println("hello $i")
            delay(200)
        }
    }

    myMethod().collect { println(it) }
}