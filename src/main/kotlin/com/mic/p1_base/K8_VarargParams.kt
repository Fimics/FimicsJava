package com.mic.p1_base



fun main(args: Array<String>) {
    hello1(1,2,4)
    hell02(1,2,3,4,5,6)
}

/**
 * 可变参数
 */
fun hello1(vararg  a:Int){
    for (i in a ){
        println(i)
    }
}

private fun hell02(vararg  int: Int){
    int.forEach { println(it) }
}