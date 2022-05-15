package com.mic.p10_polymorphism

/**
 * 扩展属性
 * 与扩展函数一样，其本质也是对应Java中的静态方法（我们反编译成Java代码后可以看到一个getSumIsEven的静态方法，
 * 与扩展函数类似）。由于扩展没有实际地将成员插入类中，因此对扩展属性来说幕后字段是无效的。这就是为什么扩展属性
 * 不能有初始化器的原因。它们的行为只能由显式提供的getters和setters定义。
 */

//1.
val MutableList<Int>.isEven: Boolean
    get() = false

/**
 * 2.表态拓展函数
 */

class Son {
    companion object {
        const val age = 10
    }
}

/**
 * 3.成员函数的优先级总高于扩展函数
 * 当扩展函数和现有类的成员方法同时存在时，Kotlin将会默认使用类的成员方法。
 */

fun Son.Companion.foo(){
    println("age = $age")
}

fun main() {
   Son.Companion.foo()
}