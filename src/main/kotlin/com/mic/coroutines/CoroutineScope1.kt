package com.mic.coroutines


import kotlinx.coroutines.*


class Activity : CoroutineScope by CoroutineScope(Dispatchers.Default) {

    fun destroy() {
        cancel()
    }

    fun doSomething() {
        repeat(8) { i ->
            launch {
                delay((i + 1) * 300L)
                println("Coroutine $i is finished")
            }
        }
    }
}

fun main() = runBlocking<Unit> {
    val activity = Activity()
    activity.doSomething()

    println("启动协程")
    delay(1300L)

    println("销毁Activity")
    activity.destroy()

    delay(9000L)
}