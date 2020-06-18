package com.mic.except

import java.lang.Integer.parseInt
import java.lang.NumberFormatException

fun main(){
    val s = "a"

    val result:Int?=try {
        parseInt(s)
    }catch (e:NumberFormatException){
        null
    }finally {
        println("finally invoked")
    }
}