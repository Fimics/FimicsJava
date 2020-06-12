package com.mic.base



fun main(args: Array<String>){
    for ( s in args){
        println(s)
    }
    out(1,2)
}

fun sum(a:Int,b:Int):Int{
    return a+b;
}

fun sum2(a:Int,b:Int) = a+b;

fun sum3(a:Int,b: Int):Unit{}

fun out(a: Int,b: Int){
    println("$a+$b = ${a+b}")
}


