package com.mic.core


//1.序列生成器 sequence

private val sequence = sequence {
    yield(1)
    yield(2)
    yield(3)
    yield(4)
    yieldAll(listOf(1, 2, 3, 4))
}

//1.2 生成数列
val fibonacci = sequence {
    yield(1L)
    var current = 1L
    var next = 1L

    while (true) {
        yield(next)
        next += current
        current = next - current
    }
}


//2.Promise模型（或者说async/await）是目前最常见也最容易理解和上手的协程实现。


fun main() {
    //1.sequence
//    for (e in sequence) {
//        println(e)
//    }

    //1.1
    fibonacci.take(10).forEach(::println)
}


