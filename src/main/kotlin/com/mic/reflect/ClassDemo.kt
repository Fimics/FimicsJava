package com.mic.reflect

import kotlin.reflect.full.memberFunctions

class MyTestClass3 {

    fun printSomething() {
        println("something")
    }

    fun printNothing() {
        println("")
    }
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
    println(class3zz.memberFunctions)

    val son:Parent =Son()
    val daughter:Parent=Daughter()
    println(son::class)
    println(son::class.java)

    println("-------")
    println(daughter::class)
    println(daughter::class.java)
}