package com.mic.reflect

import java.io.Serializable
import kotlin.reflect.full.superclasses

class MySerializable: Serializable, MyInterface

fun main() {
    val mySerializableType = MySerializable::class
    println(mySerializableType.superclasses)
}

interface MyInterface