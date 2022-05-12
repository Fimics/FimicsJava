package com.mic.p8_lambda

//fun String.filter(predicate: (Char)->Boolean):String{
//
//    val sb =StringBuffer()
//    for (index in 0 until length){
//        val e = get(index)
//        if (predicate(e)){
//            sb.append(e)
//        }
//    }
//
//    return sb.toString()
//}

fun main(){
    val str ="hell72ol9"
    println(str.filter { it.isLetter() })

    val strings = arrayOf("hello", "world", "bye", "helloworlD", "welcome")

    strings.filter { it.contains("h") }.forEach{ println(it) }

    println("--------")

    strings.filter{ it.length > 4 }.forEach { println(it) }

    println("--------")

    strings.filter { it.endsWith("d", ignoreCase = true) }.map { it.toUpperCase() }.forEach { println(it) }

    val strings1 = arrayOf("hello", "world", "bye")

    /*
    在默认情况下，lambda表达式中最后一个表达式的值会隐式作为该lambda表达式的返回值
    我们可以通过全限定的return语法来显式从lambda表达式返回值
 */
    strings1.filter {
        val mayFilter = it.length > 3
        mayFilter
    }

    strings1.filter {
        val mayFilter = it.length > 3
        return@filter mayFilter
    }
}
