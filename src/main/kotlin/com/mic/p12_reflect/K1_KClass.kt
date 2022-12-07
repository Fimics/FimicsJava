package com.mic.p12_reflect

import kotlin.reflect.full.memberFunctions

class MyTestClass3 {
    fun printSomething() { println("something") }
    fun printNothing() { println("") }
}

open class Parent
class Son:Parent()
class Daughter:Parent()

fun main(){
    val kClazz = String::class//Kclass
    println(kClazz)

    val jClazz = String::class.java
    println(jClazz)

    //成员函数
    val  class3zz = MyTestClass3::class
    class3zz.memberFunctions.forEach{ println(it) }

    val son:Parent =Son()
    val daughter:Parent=Daughter()
    println(son::class)
    println(son::class.java)

    println(daughter::class)
    println(daughter::class.java)
}