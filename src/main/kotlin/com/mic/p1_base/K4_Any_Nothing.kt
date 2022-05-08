package com.mic.p1_base

/**
 * Any 非空类型的根类
 * Any? 所有类型的根类
 *
 * Nothing Nothing处于Kotlin类型层级结构的最底层
 *  顾名思义，Nothing是没有实例的类型。Nothing类型的表达式不会产生任何值。需要注意的是，
 *  任何返回值为Nothing的表达式之后的语句都是无法执行的。你是不是感觉这有点像return或者break的作用？
 *  没错，Kotlin中return、throw等（流程控制中与跳转相关的表达式）返回值都为Nothing
 *
 *  有趣的是，与Nothing对应的Nothing？，我们从字面上翻译可能会解释为：可空的空。与Any、Any？类似，Nothing？
 *  是Nothing的父类型，所以Nothing处于Kotlin类型层级结构的最底层。
 *
 *  其实，它只能包含一个值：null，本质上与null没有区别。所以我们可以使用null作为任何可空类型的值。
 */

fun main() {
    println(convert2Uppercase("hello world"))
    println(convert2Uppercase(23))
}


fun convert2Uppercase(str: Any): String? {
    if(str is String) {
        return str.toUpperCase()
    }

    val a = arrayOf(1,2,3,4,5)
    hello(1,2,4)
    return null
}

fun hello(vararg  a:Int){
    for (i in a ){
        println(i)
    }
}