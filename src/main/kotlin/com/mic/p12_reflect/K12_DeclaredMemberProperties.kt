package com.mic.p12_reflect


import kotlin.reflect.KMutableProperty1
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.declaredMemberProperties


class MyTestClass12 {
    var name: String = "Flutter"
    val price: Double = 34.5
}

fun main() {
    val clazz = MyTestClass12::class
    val instance = clazz.createInstance()
    var props = clazz.declaredMemberProperties

    props.forEach {
        when (it.name) {
            "name" -> {
                val kmp = it as KMutableProperty1<MyTestClass12, Any>
                kmp.set(instance, "Hadoop")
                println(it.get(instance))
            }
            "price" -> {
                println(it.get(instance))
            }
        }
    }
}