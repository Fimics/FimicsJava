package com.mic.p13_kotlinjava

import java.io.FileNotFoundException

/*
    在Kotlin中，不存在checked exception
 */

class MyClass4 {

    @Throws(FileNotFoundException::class)
    fun method() {
        println("method invoked")
        throw FileNotFoundException()
    }
}