package com.mic.p16_coroutines

import kotlinx.coroutines.*

/*
    协程的取消与超时
 */

fun main() {
//   cancel1()
//    cancel2()
//    cancelWithIsActive()
//    finallyTest()
}

private fun cancel1(){
    runBlocking {
    val myJob = GlobalScope.launch {
        repeat(200) { i ->
            println("hello: $i")
            delay(500)
        }
    }

    delay(1100)
    println("hello world")

//    myJob.cancel(CancellationException("just a try"))
//    myJob.join()

    myJob.cancelAndJoin()

    println("welcome")
    }
}
/*
    kotlinx.coroutines包下的所有挂起函数都是可取消的

    他们会检查协程的取消状态，当取消时就会抛出CancellationException异常

    不过，如果协程正在处于某个计算过程当中，并且没有检查取消状态，那么它就是无法被取消的
 */
private fun cancel2(){
    runBlocking {
        val startTime = System.currentTimeMillis()
        val job = launch(Dispatchers.Default) {
            var nextPrintTime = startTime

            var i = 0

            while (i < 20) {
                if (System.currentTimeMillis() >= nextPrintTime) {
                    println("job: I am sleeping ${i++}")
                    nextPrintTime += 500L
                }
            }
        }

        delay(1300)
        println("hello world")

        job.cancelAndJoin()
        println("welcome")
    }
}

/*
    有两种方式可以让计算代码变为可取消的：

    1. 周期性地调用一个挂起函数，该挂起函数会检查取消状态，比如说使用yield函数
    2. 显式地检查取消状态

    如下示例将会采用第二种方式

    其中，isActive是协程的一个扩展属性，它是通过CoroutineScope对象添加的
 */
private fun cancelWithIsActive(){
    runBlocking {
        val startTime = System.currentTimeMillis()
        val job = launch(Dispatchers.Default) {
            var nextPrintTime = startTime

            var i = 0

            while (isActive) {
                if (System.currentTimeMillis() >= nextPrintTime) {
                    println("job: I am sleeping ${i++}")
                    nextPrintTime += 500L
                }
            }
        }

        delay(1300)
        println("hello world")

        job.cancelAndJoin()
        println("welcome")
    }
}

/*
    使用finally来关闭资源

    join与cancelAndJoin都会等待所有清理动作完成才会继续往下执行
 */
private fun finallyTest(){
    runBlocking {
        val myJob = launch {
            try {
                repeat(100) { i ->
                    println("job: I am sleeping $i")
                    delay(500)
                }
            } finally {
                println("执行了finally块")
            }
        }

        delay(1300)
        println("hello world")

        myJob.cancelAndJoin()
        println("welcome")
    }
}
