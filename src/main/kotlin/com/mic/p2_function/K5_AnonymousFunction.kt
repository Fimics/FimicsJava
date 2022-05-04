package com.mic.p2_function

/**
 * 匿名函数
 *https://blog.csdn.net/qq_41872247/article/details/116720795
 * 和具名函数一样，匿名函数可以不带参数，也可以带一个或多个任何类型的参数，需要参数时，
 * 参数的类型放到匿名函数的类型定义中，参数名放到函数定义中
 */


val blessingFunction:()->String={
    val holiday="New Year."
    "Happy $holiday"
}

val blessingFunction2:(String)->String={name->
    val holiday="New Year."
    "$name, Happy $holiday"
}


fun main(){

    println(::blessingFunction)
}