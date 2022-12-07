package com.mic.p1_base

/**
 * Int ? 可空类型
 */
fun main() {
    println(convert2Int("ab"))
    printMultiply("2", "3")
    printMultiply("2", "a")
    printMultiply2("3", "4")
}


//Int? 返回值允许为空
fun convert2Int(str: String): Int? {
    try {
        return str.toInt()
    } catch (ex: NumberFormatException) {
        return null
    }
}

fun printMultiply(a: String, b: String) {
    val a2Int = convert2Int(a)
    var b2Int = convert2Int(b)

    if(null != a2Int && null != b2Int) {
        println(a2Int * b2Int)
    } else {
        println("param not int")
    }
}

fun printMultiply2(a: String, b: String) {
    val a2Int = convert2Int(a)
    var b2Int = convert2Int(b)

//    println(a2Int * b2Int)

    //返回值是Int? 类型并不是null类型所以下边的代码没有进来
    if (null == a2Int) {
        println("param not int1")
    } else if (null == b2Int) {
        println("param not int")
    } else {
        println(a2Int * b2Int)
    }
}