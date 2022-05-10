package com.mic.p5_type_system_generics

/**
 *System.out.println(appleArray.getClass());
 * System.out.println(appleList.getClass());
 * //运行结果class[Ljavat.Apple; classjava.util.ArrayList
 *
 * 1.数组在运行时是可以获取自身的类型，而List<Apple>在运行时只知道自己是一个List，而无法获取泛型参数的类型。
 * 而Java数组是协变的，也就是说任意的类A和B，若A是B的父类，则A[]也是B[]的父类。但是假如给数组加入泛型后，
 * 将无法满足数组协变的原则，因为在运行时无法知道数组的类型。
 */


fun testGenerics{
    val appleList = ArrayList<Apple>()
    println(appleList.javaClass)

    //Kotlin中的数组是支持泛型的，当然也不再协变，也就是说你不能将任意一个对象数组赋值给Array<Any>或者Array<Any？>。在Kotlin中Any为所有类的父类，

}

fun main(){
    testGenerics()
}