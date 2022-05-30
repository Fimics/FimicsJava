package com.mic.p17_flow

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.runBlocking


/*
    Flow的组合 把多个流的内容组合到一起
 */

fun main() = runBlocking<Unit> {
    val nums = (1..5).asFlow()
    val strs = flowOf("one", "two", "three", "four", "five")

    nums.zip(strs) { a, b -> "$a -> $b" }.collect { println(it) }
}