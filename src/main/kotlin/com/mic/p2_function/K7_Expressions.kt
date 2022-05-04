package com.mic.p2_function

/**
 * 面向表达式编程
 * 1.if  表达式
 * 2.函数体  表达式
 * 3.Lambda  表达式
 * 4.函数引用  表达式
 */


/**
 * 匿名函数
 * https://blog.csdn.net/qq_41872247/article/details/116720795
 */
private fun test1(a:Int,b:(Int,Int)->Int):Int{
    return  a+b(1,2)
}

private fun ifExpression(flag:Boolean){
    val a = if(flag) "dive into Kotlin" else ""
    println(a)
}

//复合表达式




fun main(){
  println(test1(1) { a, b -> a + b })
}