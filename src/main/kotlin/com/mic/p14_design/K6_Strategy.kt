package com.mic.p14_design

/**
 * 1.策略模式定义了算法族，分别封装起来，让它们之间可以相互替换，此模式让算法的变化独立于使用算法的客户。
 * 2.本质上，策略模式做的事情就是将不同的行为策略（Strategy）进行独立封装，与类在逻辑上解耦。
 * 然后根据不同的上下文（Context）切换选择不同的策略，然后用类对象进行调用。下面我们用熟悉的方式重新实现游泳的例子：
 *
 * 这个方案实现了解耦和复用的目的，且很好实现了在不同场景切换采用不同的策略。
 * 然而，该版本的代码量也比之前多了很多。下面我们来看看Kotlin如何用高阶函数来简化策略模式。
 */

//1.传统方法实现策略模式
private interface SwimStrategy {
    fun swim()
}

private class Breaststroke : SwimStrategy {
    override fun swim() {
        println("Breaststroke")
    }
}

private class BackStoke : SwimStrategy {
    override fun swim() {
        println("BackStoke")
    }
}

private class Freestyle : SwimStrategy {
    override fun swim() {
        println("Freestyle")
    }
}

private class Swimmer(val strategy: SwimStrategy) {
    fun swim() {
        strategy.swim()
    }
}

//2.高阶函数实现策略模式

fun breaststroke() {
    println("breaststroke")
}

fun backstroke() {
    println("backstroke")
}

fun freestyle(){
    println("freestyle")
}

private class Swimmer1(val swimming:()->Unit){
    fun swim(){
        swimming()
    }
}

fun main() {
//    val weekendShaw = Swimmer(Freestyle())
//    weekendShaw.swim()
//
//    val weekDayShaw = Swimmer(Breaststroke())
//    weekDayShaw.swim()

    val weekendShaw = Swimmer1(::freestyle)
    weekendShaw.swim()

    val weekdayShaw = Swimmer1(::breaststroke)
    weekdayShaw.swim()
}

