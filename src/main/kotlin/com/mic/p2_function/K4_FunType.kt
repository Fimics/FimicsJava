package com.mic.p2_function


/**
 * 函数类型
 *，1.Kotlin还支持为声明参数指定名字，
 * (errCode:Int,errMsg:String)->Unit
 *
 *
 * 2.(errCode:Int,errMsg:String?)->Unit
 *
 * 3.如果该函数类型的变量也是可选的话，我们还可以把整个函数类型变成可选：
 * ((errCode:Int,errMsg:String?)->Unit)?
 *
 * 4.高阶函数还支持返回另一个函数，所以还可以这么做：(Int)->((Int)->Unit)
 * 这表示传入一个类型为Int的参数，然后返回另一个类型为（Int）->Unit的函数
 * 。简化它的表达，我们可以把后半部分的括号给省略：
 * (Int)->Int->Unit需要注意的是，
 *
 * 5.以下的函数类型则不同，它表示的是传入一个函数类型的参数，再返回一个Unit。
 * ((Int)->Int)->Unit
 */


private class Book(val name:String)

fun main(){
    val getBook = ::Book
    println(getBook("Dive into kotlin").name)
}