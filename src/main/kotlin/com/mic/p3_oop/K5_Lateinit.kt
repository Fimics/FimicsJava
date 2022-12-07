package com.mic.p3_oop


/*
    var propertyName: propertyType = initializer
        getter()...
        setter()...

    backing field，支撑字段（域）
    backing property，支撑属性
 */

class LPerson(address:String,name: String){

    //属性初始化
//    val age:Int = 20
    val age:Int
         get() = 20;

    var address:String = address
        get() {
            println("get address")
            return field
        }
        set(value){
            println("set address")
            field = value
        }
    var name:String=name
}

/**
 * 延迟初始化属性
 *
 * Kotlin要求非空类型的属性必须要在构造方法中进行初始化
 * 有时，这种要求不太方便，比如可以通过依赖注入或是单元测试情况下进行属性的赋值。
 *
 * 通过lateinit关键字标识属性为延迟初始化，需要满足如下3个条件：
 *
 * 1. lateinit只能用在类体中声明的var属性上，不能用在primary constructor声明的属性上
 * 2. 属性不能拥有自定义的setter与getter
 * 3. 属性类型需要为非空，且不能是原生数据类型
 *
 */

class TheClass {

    lateinit var name: String

    fun init() {
        this.name = "zhangsan"
    }

    fun print() {
        println(this.name)
    }
}


fun  main(){
    var person = LPerson("shanghai", "zhangsan")

    println(person.age)

    println(person.address)

    person.address = "tianjin"
    println(person.address)

    println(person.name)

    person.name = "lisi"

    println(person.name)

    var theClass = TheClass()

    println("---lateinit")
    theClass.init()
    theClass.print()
}