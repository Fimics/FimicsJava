package com.mic.except

import java.lang.Integer.parseInt
import java.lang.NumberFormatException

fun main(){
    val s = "a"

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