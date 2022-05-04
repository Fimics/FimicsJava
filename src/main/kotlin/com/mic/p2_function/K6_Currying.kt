package com.mic.p2_function


/**
 * “柯里化”风格、扩展函数
 *
 * 如果你看过一些介绍函数式编程的文章，可能听说过一种叫作“柯里化（Currying）”的语法，
 * 其实它就是函数作为返回值的一种典型的应用。
 *
 * 简单来说，柯里化指的是把接收多个参数的函数变换成一系列仅接收单一参数函数的过程，
 * 在返回最终结果值之前，前面的函数依次接收单个参数，然后返回下一个新的函数。
 */

private fun foo(x:Int)={y:Int->x+y}

private fun foo1(x:Int):(Int)->Int{
    return {y:Int->x+y}
}

/**
 * 在我们之前介绍过的Lambda表达式中，还存在一种特殊的语法。如果一个函数只有一个参数，且该参数为函数类型，
 * 那么在调用该函数时，外面的括号就可以省略，就像这样子：
 *
 * fun omitParentheses(block:()->Unit){
 * block()
 * }
 * omitParentheses{
 * println("parentheses is omitted")
 * }
 * 此外，如果参数不止一个，且最后一个参数为函数类型时，就可以采用类似柯里化风格的调用：
 * fun curryingLike(content:String,block:(String)->Unit){
 * block(content)
 * }
 *
 * curryingLike("lookslikecurryingstyle"){
 * content->
 * println(content)
 * }
 */


fun main(){

    println(foo(3)(2))
}