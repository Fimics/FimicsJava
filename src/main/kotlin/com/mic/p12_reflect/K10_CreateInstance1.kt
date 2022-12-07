package com.mic.p12_reflect

import kotlin.reflect.full.createInstance


class MyTestClass10(var name: String) {
    var price = 0.0
    constructor(): this("未知商品") {
        this.price = 0.0
    }
    constructor(name: String, price: Double) : this(name) {
        this.price = price
    }
}

fun main() {
    val clazz = MyTestClass10::class
    val instance = clazz.createInstance()

    println(instance.name)
    println(instance.price)

    val cons = clazz.constructors

    cons.forEach {
        if (it.parameters.size == 2) {
            val instance2 = it.call("python", 34.5)

            println(instance2.name)
            println(instance2.price)
        }
    }
}