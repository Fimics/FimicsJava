package com.mic.p7_delegate

import kotlin.properties.Delegates

/**
 * 适用于那些无法在初始化阶段确认属性值的场合。lateinit 修饰符只能在类（不在主构造函数中）内声明的var 属性上使用，
 * 而且只有在该属性没有自定义集合或者设置器时，此外属性的类型必须是非空的，
 * 并且不能是基元类型。而非空属性没有这些限制。其他他们的作用是相同的。如下是一个案例：
 */

class NotNull {
}

class Tree {
    //非空属性解决了 var name: String? = null 导致后续判断冗余
    //非空属性解决了 var name: String = "" 初值隐晦问题
    //非空属性解决了 lateinit 的一些缺陷，譬如 lateinit 只能应用于非基元类型，譬如不能用于 Int 等问题
    var name: String by Delegates.notNull<String>()
}

/**
调用
 */
fun main() {
    val tree = Tree()
    //运行时异常，没有赋值而使用 IllegalStateException: Property name should be initialized before get.
//    println(tree.name)
    tree.name = "123"
    println(tree.name)
}
