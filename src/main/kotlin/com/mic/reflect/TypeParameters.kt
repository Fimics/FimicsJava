package com.mic.reflect

class MyTestClass<K, V> {

    var k: K? = null

    var v: V? = null
}

fun main(args: Array<String>) {
    val myTestClassType = MyTestClass::class
    println(myTestClassType.typeParameters)

    println(myTestClassType.typeParameters.size)

    println("first type: " + myTestClassType.typeParameters[0])
    println("second type: " + myTestClassType.typeParameters[1])
}