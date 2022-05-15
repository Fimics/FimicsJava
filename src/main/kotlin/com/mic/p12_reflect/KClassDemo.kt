package com.mic.p12_reflect

import kotlin.reflect.KClass

fun main(){
    val kotlinLang = "kotlin"
    val kclass: KClass<out String> = kotlinLang::class
    println(kclass)

    println("------------")

    val kclassDataType: KClass<String> = String::class
    println(kclassDataType)

    println("------------")

    val kclass1: KClass<out String> = "kotlin"::class
    val kclass2: KClass<out String> = "java"::class
    val kclass3: KClass<out String> = "ruby"::class

    println(kclass1)
    println(kclass2)
    println(kclass3)
    println(kclass1 == kclass2)

    println("------------")

    //获取kotlin 中对应的Kclass对象
    val kclass4 = Class.forName("java.util.Date").kotlin
    println(kclass4)

    println(kclass4 == Class.forName("java.util.Date"))
    println(kclass4 == Class.forName("java.util.Date").kotlin)
}