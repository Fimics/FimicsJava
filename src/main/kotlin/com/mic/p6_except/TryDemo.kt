package com.mic.p6_except

import java.lang.Integer.parseInt
import java.lang.NumberFormatException

fun main(){
    var s = "3"

    val result:Int?=try {
        parseInt(s)
    }catch (e:NumberFormatException){
        println("null000")
        null
    }finally {
        println("finally invoked")
    }

    println(result)
}