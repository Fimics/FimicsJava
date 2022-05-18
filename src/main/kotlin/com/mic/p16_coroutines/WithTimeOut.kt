package com.mic.p16_coroutines

import kotlinx.coroutines.*

fun main(){
//    withContext()
    withTimeOut()
}


/*
    对于该示例来说，当我们在协程的finally块中使用了挂起函数时，会导致出现CancellationException异常，原因在于运行着该代码块
    的协程已经被取消了。通常情况下，这并不会产生什么问题，因为大多数关闭操作（比如说取消一个job、关闭网络连接等）通常都是非阻塞的，
    并不需要使用挂起函数；然而，在极少数情况下，当我们在一个取消的协程中进行挂起操作时，我们可以将相应的代码放置到withContext(NonCancellable) {}
    当中，在这种结构中，我们实际上使用了withContext函数与NonCancellable上下文。

 */
private fun withContext() {
    runBlocking {
        val myJob = launch {
            try {
                repeat(100) { i ->
                    println("job: I am sleeping $i")
                    delay(500)
                }
            } finally {
                withContext(NonCancellable) {
                    println("执行了finally块")
                    delay(1000)
                    println("在delay后执行的代码片段")
                }
            }
        }

        delay(1300)
        println("hello world")

        myJob.cancelAndJoin()
        println("welcome")
    }

}

/*
    我们在使用协程时，如果取消了协程，那么很大一部分原因都在于协程的执行时间超过了某个设定值；我们可以通过手工引用与协程对应的Job的
    方式来启动一个单独的协程用于取消这个协程，不过Kotlin提供了一个内建的函数来帮助我们又快又好地做到这一点。
 */
private fun withTimeOut() {
    runBlocking {
        withTimeout(1900) {
            repeat(1000) { i ->
                println("hello, $i")
                delay(400)
            }
        }
    }
}


/*
    由withTimeout函数调用所抛出的TimeoutCancellationException异常是CancellationException的子类，当该异常抛出时，我们并未
    在控制台上看到整个异常堆栈信息，这是因为在取消的协程当中，CancellationException被认为是一种协程完成的正常原因而已。

    不过，我们在该示例中，是在main函数中使用了withTimeout函数调用

    既然CancellationException仅仅只是个异常而已，所有的资源也都会以通常的方式来关闭，那么我们就可以将相关代码放到一个try...catch
    块中；此外，Kotlin还提供了另外一个更加友好的函数调用：withTimeoutOrNull；从功能角度来看，它非常类似于withTimeout，不过当超时
    发生时，它并不会抛出CancellationException异常，而是会直接返回null

    对于withTimeout函数调用来说，如果将其放置到try...catch块中，那么调用形式就是下面这样：

    try {
        ....
    } catch(ex: TimeoutCancellationException) {
        ...
    }
 */
private fun withTimeOut2(){
    runBlocking {
        val result = withTimeoutOrNull(1900) {
            repeat(1000) { i ->
                println("hello, $i")
                delay(300)
            }

            "hello world"
        }

        println("Result is $result")
    }

}