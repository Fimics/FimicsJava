package com.mic.p10_polymorphism

/**
 * 1.子类型多态
 * 2.参数多态
 * 3.特设多态  ，operator, 扩展函数
 *
 * 当我们用一个子类继承一个父类的时候，这就是子类型多态（Subtypepolymorphism）。
 *
 * 另一种熟悉的多态是参数多态（Parametricpolymorphism），我们在第5章所讨论的泛型就是其最常见的形式。
 *
 * 此外，也许你还会想到C++中的运算符重载，我们可以用特设多态（Adhocpolymorphism）来描述它。
 * 相比子类型多态和参数多态，可能你对特设多态会感到有些许陌生。其实这是一种更加灵活的多态技术，
 * 在Kotlin中，一些有趣的语言特性，如运算符重载、扩展都很好地支持这种多态。
 */

//interface Sumable<T> {
//    fun plusThat(that: T): T
//}
//
//data class Len(val v: Int) : Sumable<Len> {
//    override fun plusThat(that: Len): Len {
//        return Len(this.v+that.v)
//    }
//}

data class Area(val value:Double)

/**
 * Kotlin中内置可重载的运算符plus。先来看看operator，它的作用是：将一个函数标记为重载一个操作符或者实现一个约定。
 * TODO 53%处
 */
operator fun Area.plus(that:Area):Area{
    return Area(this.value+that.value)
}

fun main() {

}