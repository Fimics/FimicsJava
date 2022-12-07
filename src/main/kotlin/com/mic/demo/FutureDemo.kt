package com.mic.demo

import java.util.concurrent.*

private class FutureDemo {
    private val executor:ExecutorService = Executors.newSingleThreadExecutor()

    fun calculate(input :Int): Future<Int> {
         return executor.submit(Callable<Int> {
             println("calculating...$input")
             Thread.sleep(1000)
             input*input
         })
    }
}

fun main() {
    val futureDemo = FutureDemo()
    println("start")
    val future=futureDemo.calculate(20);
    //get 会一直阻塞线程，下边的代码不能执行
//    val value =future.get()
    //如果我们不想等待，future提供了一个带时间的方法：
    val value = future.get(1800,TimeUnit.MILLISECONDS)
    println("value done ->$value")

    while (!future.isDone){
        println("calculating... while")
        Thread.sleep(100)
    }
    println("end")
}

