package com.mic.p2_function

/**
 * Lambda表达式  闭包
 * TODO 理解多少？
 * TODO Kotlin Invoke()方法
 */

//lambda 的形式定义一个加法操作
//一个Lambda表达式必须通过{}来包裹；
val sum :(Int,Int)->Int={x:Int,y:Int->x+y}


//由于支持类型推倒，可以用两简化的方式简化

//如果Lambda声明了参数部分的类型，且返回值类型支持类型推导，那么Lambda变量就可以省略函数类型声明；
val sum1={x:Int,y:Int ->x+y}

//如果Lambda变量声明了函数类型，那么Lambda的参数部分的类型就可以省略。
val sum2:(Int,Int)->Int = {x,y->x+y}

//如果Lambda表达式返回的不是Unit，那么默认最后一行表达式的值类型就是返回值类型

private val foo={x:Int->
    val y = x+1
    y //返回值是y
}

/**
 * 可以直接输出结果
 */
private fun foo1(int:Int)=  println(int)

/**
 * 必须调用invoke 才能输出结果
 *
 * invoke
 *
 */
fun foo2(int:Int)={ println(int) }

/**
 * fun 声明函数 与Lambda表表达式区分
 *
 * 1.·fun在没有等号、只有花括号的情况下，是我们最常见的代码块函数体，如果返回非Unit值，必须带return。
 * fun foo(x:Int){print(x)}
 * fun foo(x:Int,y:Int):Int{return x*y}
 *
 * 2.fun带有等号，是单表达式函数体。该情况下可以省略return。
 * fun foo(x:Int,y:Int)=x+y
 *
 * 3.不管是用val还是fun，如果是等号加花括号的语法，那么构建的就是一个Lambda表达式，
 * Lambda的参数在花括号内部声明。所以，如果左侧是fun，那么就是Lambda表达式函数体，也必须通过（）或invoke来调用Lambda，
 *val foo={x:Int,y:Int>x+y}//foo.invoke(1,2)或foo(1,2)
 *
 * fun foo(x:Int)={y:Int>x+y}//foo(1).invoke(2)或foo(1)(2)在Kotlin中，
 *
 * 你会发现匿名函数体、Lambda（以及局部函数、object表达式）在语法上都存在“{}”
 * 这对花括号包裹的代码块如果访问了外部环境变量则被称为一个闭包。一个闭包可以被当作参数传递或者直接使用，
 * 它可以简单地看成“访问外部环境变量的函数”。Lambda是Kotlin中最常见的闭包形式。
 * 与Java不一样的地方在于，Kotlin中的闭包不仅可以访问外部变量，还能够对其进行修改
 */



fun main(){

//    println(sum(2,3))
//
//    println(foo(1))

//    listOf(1,2,3).forEach { foo2(it).invoke() }
    listOf(1,2,3).forEach { foo2(it)() }

    //闭包
    var sum =0
    listOf<Int>(1,2,3,4)
        .filter {
            it>0
        }.forEach {
            sum+=it
        }
    println("sum = $sum")
}