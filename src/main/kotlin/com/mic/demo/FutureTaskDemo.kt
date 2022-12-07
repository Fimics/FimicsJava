package com.mic.demo

import java.util.concurrent.Callable
import java.util.concurrent.FutureTask
import java.util.concurrent.ThreadLocalRandom


fun main() {
    futureTaskTest()
}

fun futureTaskTest(){
    //// 需要借助FutureTask
   val task : FutureTask<Int> = FutureTask(object : Callable<Int> {
       override fun call(): Int {
           println("futureTaskTest call..start")
           return ThreadLocalRandom.current().nextInt()
       }
   })

  val thread=Thread(task)
  thread.start()
  println("task get=="+task.get())

}