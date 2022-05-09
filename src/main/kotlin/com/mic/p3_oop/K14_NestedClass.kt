package com.mic.p3_oop

fun main(){
   println(OuterClass.NestedClass().nestedMethod())
    val nestedClass4: OuterClass4.NestedClass4 = OuterClass4.NestedClass4()
}

// 嵌套类（Nested Class）
// 嵌套类不能访问外部类的其他成员，只能访问另一个嵌套类

class OuterClass{

    private val str:String="hello world"

    class NestedClass{
        fun nestedMethod()="welcome"
    }


    class Nested2Class{
        val nestedclass = NestedClass()

    }
}

class OuterClass4 {

    class NestedClass4 {
        init {
            println("NestedClass4构造块执行")
        }
    }
}