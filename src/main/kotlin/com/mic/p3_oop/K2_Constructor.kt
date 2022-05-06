package com.mic.p3_oop

class EmptyClass
class EmptyClass1{}

// 在Kotlin中，一个类可以有一个primary构造方法以及一个或多个secondary构造方法
// primary构造方法是类头（class header）的一部分，它位于类名后面，可以拥有若干参数

// 如果primary构造方法没有任何注解或是可见性关键字修饰，那么constructor关键字可省略
//constructor(userName: String) 这个就是主构造方法
class MyClass constructor(var userName: String){
    private  var age:Int = 0;
    private  var address:String


    //初始化代码块，主要给类的属性赋初值的，在初始化代码块中可以使用构造方法的参数
    init {
        println(userName)
        userName ="hello";
        this.age=20;
        this.address="beijing"
    }

    //secondary构造方法 必须直接或间接调用primary构造方法 用冒号分隔是直接调用
    constructor(userName: String,age:Int):this(userName){
        println(userName+""+ age)
        this.age = age
        this.address = "beijing"
    }

    constructor(userName: String,age: Int,address:String):this(userName,age){
       this.address=address;
    }

    override fun toString(): String {
        return "MyClass( age=$age, address='$address')"
    }
}

//private val username: String, 这样写默认作为类的成员属性
class Student (private val username: String, private val age: Int, private var address: String) {

    fun printInfo() {
        println("username: $username, age: $age, address: $address")
    }
}

/**
 * 如果构造方法拥有注解或是可见性修饰符，
 * 那么constructor关键字就是不能省略掉的，并且它位于修饰符后面
 */

class Student2 private constructor(username: String) {

}

/**
 * 在JVM上，如果类的primary构造方法的所有参数都拥有默认值，那么kotlin编译器就会为这个类生成一个不带参数的构造方法，
 * 这个不带参数的构造方法会使用这些参数的默认值，这样做的目的在于可以跟Spring等框架更好地集成。
 */

class Student3 (val username: String = "zhangsan") {

}


fun main(){
    var myClass = MyClass("steven")

    val  mc = MyClass("zhangsan")
    val  mc1 = MyClass("lishi",33)
    val mc2 = MyClass("wangwu",44,"henan")

    listOf(mc,mc1,mc2).forEach {
        println(it.toString())
    }

}