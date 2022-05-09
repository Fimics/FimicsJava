package com.mic.p3_oop

open class MyParent {
    //属性重写
    open val name: String = "parent"
}

class MyChild: MyParent() {
    override val name: String = "child"
}

fun main() {
    var myChild = MyChild()
    println(myChild.name)

    println("------")

    var myChild3 = MyChild3()
    myChild3.method()
    println(myChild3.name)

}


class MyChild2(override val name: String): MyParent() {

}

// 1. val 可以 override val
// 2. var 可以 override val
// 3. val 无法 override var

// 本质上，val相当于get方法；var相当于get与set方法

open class MyParent3 {
    open fun method() {
        println("parent method")
    }

    open val name: String get() = "parent"
}

class MyChild3: MyParent3() {
    override fun method() {
        super.method()

        println("child method")
    }

    override val name: String
        get() = super.name + " and child"

}