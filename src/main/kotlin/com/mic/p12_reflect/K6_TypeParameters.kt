package com.mic.p12_reflect

class MyTestClass<K, V> {
    var k: K? = null
    var v: V? = null
}

fun main() {
    val myTestClassType = MyTestClass::class
    println(myTestClassType.typeParameters)
    println(myTestClassType.typeParameters.size)
    println("first type: " + myTestClassType.typeParameters[0])
    println("second type: " + myTestClassType.typeParameters[1])
}