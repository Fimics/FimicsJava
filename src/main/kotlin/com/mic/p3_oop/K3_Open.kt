package com.mic.p3_oop


// 在Kotlin中，所有类在默认情况下都是无法被继承的，
// 换句话说，在Kotlin中，所有类默认情况下都是final的
// open的含义与final相反

open class Parent (name: String, age: Int) {

}

class Child(name: String, age: Int): Parent(name, age) {

}

class Child3(name: String,age: Int,address:String):Parent(name,age){

}

open class Parent2(name: String) {

}

// 在Kotlin中，如果一个类没有primary构造方法，那么这个类的每个secondary构造方法就需要通过
// super关键字来初始化父类型，或是通过其他secondary构造方法完成这个任务
// 不同的secondary构造方法可以调用父类型不同的构造方法

class Child2: Parent2 {

    constructor(name: String): super(name) {
    }
}

class Child4:Parent2{

    constructor(name: String):super(name){}
}


open class Fruit {
    open fun name() {
        println("fruit")
    }

    fun expirationDate() {
        println("1 month")
    }
}

class Apple: Fruit() {
    override fun name() {
        println("apple")
    }

}

open class Orange: Fruit() {
    final override fun name() {
        println("orange")
    }
}


fun main() {
    var apple = Apple()
    apple.name()
    apple.expirationDate()
}