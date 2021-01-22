package com.mic.base

fun main(args: Array<String>) {
    hello1(1,2,4)
}


fun hello1(vararg  a:Int){
    for (i in a ){
        println(i)
    }
}