package com.mic.base

//https://www.jianshu.com/p/97d6f55dd4c3  Kotlin-数组与集合-Array
fun main(args: Array<String>) {
    var myarray = arrayOf(1,2,4,"hello")
    var m1 :Array<Int> =  Array(2){0};
    m1[0]=0
    m1[1]=1
    for ( i in m1){
        println(m1[i])
    }

    for (a in myarray){
        when(a){
            1,2,4-> println("数字")
            is String-> println("字符串")
        }
    }
}