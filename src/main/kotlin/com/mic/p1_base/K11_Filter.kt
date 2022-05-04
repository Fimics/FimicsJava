package com.mic.p1_base


fun main() {
    var array = listOf<String>("hello", "world", "hello world", "welcome", "goodbye")

    for (item in array) {
        println(item)
    }

    println("-----")

    when{
        "world" in array-> println("world int collection")
    }

    //it 当前遍历的对象
    array.filter { it.length>5 }
            //map 转换
            .map { it.toUpperCase() }
            //自然排序
            .sorted()
            //遍历
            .forEach { println(it) }

}