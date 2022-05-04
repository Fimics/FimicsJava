package com.mic.p1_base

//流程控制

fun main(){

    var x = 10
    var y = 20

    var max =if(x>y) x else y
    var min =if(x>y) y else x

    println("max=$max,min=$min")

    var max1 = if (x > y) {
        println("x > y")
        x
    } else {
        println("x <= y")
        y
    }

    var min1 = if (x > y) {
        println("x > y")
        y
    } else {
        println("x <= y")
        x
    }

    println("max1 = $max1, min1 = $min1")
}

