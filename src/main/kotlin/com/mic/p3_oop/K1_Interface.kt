package com.mic.p3_oop

//java8 中的接口加上default关键字可以有默认方法实现
//原因: 1.向后兼容性，2.对stream的支持

interface A{
    fun  method(){
        println("A")
    }

//    val height = 10;
       val height get() = 10

}

open class B{
    open fun method(){
        println("B")
    }
}

class C:A,B(){
    override fun method() {
        super<B>.method()
        super<A>.method()
    }
}

fun main(){
    var c = C()
    c.method()
}
