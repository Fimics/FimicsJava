package com.mic.p2_function

fun main() {
    val count = sumCount2(3,5)
    println(count)

    val f = foo(2)
    println(f)

    val list = listOf<Int>(1,2,3)
    list.forEach { foo1(it).invoke() }
//    list.forEach { foo1(it)() }

    fpp.invoke(1,2)
    fpp(1,2)

    ff(1).invoke(2)
    ff(1)(2)

    //与Java不一样的地方在于，Kotlin中的闭包不仅可以访问外部变量，还能够对其进行修改，就像这样子
    var sum =0
    listOf<Int>(1,2,3).filter { it>0 }.forEach {
        sum+=it
    }

}

//一个Lambda表达式必须通过{}来包裹；
private val sumCount: (Int, Int) -> Unit = { x: Int, y: Int -> Unit }

private val sumCount1: (Int, Int) -> Int = { x: Int, y: Int -> x + y }

//如果Lambda声明了参数部分的类型，且返回值类型支持类型推导，那么Lambda变量就可以省略函数类型声明；
private val sumCount2 = { x: Int, y: Int -> x + y }

//如果Lambda变量声明了函数类型，那么Lambda的参数部分的类型就可以省略。
private val sumCount3:(Int,Int)->Int={x,y->x+y}

//如果Lambda表达式返回的不是Unit，那么默认最后一行表达式的值类型就是返回值类型
private val foo={x:Int->
    val y = x+1
    y//返回值是y
}

//为啥调用invoke才执行？
private fun foo1(age:Int)={ println(age) }

/**
 * 不管是用val还是fun，如果是等号加花括号的语法，那么构建的就是一个Lambda表达式，Lambda的参数在花括号内部声明。
 * 所以，如果左侧是fun，那么就是Lambda表达式函数体，也必须通过（）或invoke来调用Lambda，如
 */

/**
 * 在Kotlin中，你会发现匿名函数体、Lambda（以及局部函数、object表达式）在语法上都存在“{}”，
 * 由这对花括号包裹的代码块如果访问了外部环境变量则被称为一个闭包。一个闭包可以被当作参数传递或者直接使用，
 * 它可以简单地看成“访问外部环境变量的函数”。Lambda是Kotlin中最常见的闭包形式。
 */
val fpp={x:Int,y:Int->x+y}
fun  ff(x:Int)={y:Int->x+y}

//柯里化风格 扩展函数 ，即一个函数返回另一个函数作为结果。
//简单来说，柯里化指的是把接收多个参数的函数变换成一系列仅接收单一参数函数的过程，在返回最终结果值之前，前面的函数依次接收单个参数，然后返回下一个新的函数。

fun ttt(x:Int)={y:Int->x+y}
//等价于以下：
fun ttt1(x:Int):(Int)->Int{
    return {y:Int->x+y}
}

private fun sum(x:Int,y:Int,z:Int)=x+y+z
//sum(1,2,3)
private fun sum1(x:Int)={y:Int->
    {z:Int->x+y+z}
}
