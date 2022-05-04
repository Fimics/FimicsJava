package com.mic.p1_base



fun main(args: Array<String>) {
    hello1(1,2,4)
}

/**
 * 可变参数
 */
fun hello1(vararg  a:Int){
    for (i in a ){
        println(i)
    }
}