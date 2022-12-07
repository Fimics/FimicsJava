package com.mic.demo

import java.util.concurrent.CompletableFuture

fun getResult(input:Int):CompletableFuture<Int>{

    return CompletableFuture.supplyAsync {
        println("input-> $input")
        Thread.sleep(1000)
        input*input
    }
}

fun main() {
    println("start")
    getResult(10).thenAccept {
        println("completed and value= $it")
    }

    println("end")
}

