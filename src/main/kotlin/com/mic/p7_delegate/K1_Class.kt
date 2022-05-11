package com.mic.p7_delegate

// 委托（delegation）
// 类委托
//https://blog.csdn.net/yanbober/article/details/109404014

interface MyInterface{
    fun MyPrint()
}

class MyInterfaceImpl(val str:String):MyInterface{
    override fun MyPrint() {
        println("welcome "+str)
    }
}

/*
   委托原理：
   by关键字后面的对象实际上会被存储在类的内部，编译器则会把接口中的所有方法实现出来，并且将
   实现转移给委托对象来去进行
 */

class MyClass(myInterface: MyInterface):MyInterface by myInterface{}

//kotlin推荐的类委托实现的重写
class MyDelegation(val myInterface: MyInterface):MyInterface by myInterface{
    override fun MyPrint() {
        myInterface.MyPrint()
        println("MyDelegation")
    }
}

fun main(){
    val myInterfaceImpl = MyInterfaceImpl("lishi")
    myInterfaceImpl.MyPrint()
    MyClass(myInterfaceImpl).MyPrint()
    MyDelegation(myInterfaceImpl).MyPrint()
}