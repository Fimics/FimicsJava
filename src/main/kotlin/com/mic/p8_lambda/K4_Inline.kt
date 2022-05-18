package com.mic.p8_lambda

import com.mic.p16_coroutines.Activity


/**
1.内联函数（inline function）连接到一起
在Kotlin中每声明一个Lambda表达式，就会在字节码中产生一个匿名类。该匿名类包含了一个invoke方法，
作为Lambda的调用方法，每次调用的时候，还会创建一个新的对象。可想而知，Lambda语法虽然简洁，
但是额外增加的开销也不少。尤其对Kotlin这门语言来说，它当今优先要实现的目标，就是在Android这个平台上提供良好的语言特性支持。
如果你熟悉Android开发，肯定了解Java6是当今Android主要采用的开发语言，Kotlin要在Android中引入Lambda语法，
必须采用某种方法来优化Lambda带来的额外开销，也就是内联函数。
 */

/**
 * 直接放到代码调用处，生成的字节码比较大
 */
inline fun myCalculate(a: Int, b: Int) = a + b

private fun foo(block: () -> Unit) {
    println("before block")
    block()
    println("after block")
}

private inline fun foo2(block: () -> Unit) {
    println("before block")
    block()
    println("after block")
}

/**
 * 2.以下情况我们应避免使用内联函数：
 * ·由于JVM对普通的函数已经能够根据实际情况智能地判断是否进行内联优化，
 * 所以我们并不需要对其实使用Kotlin的inline语法，那只会让字节码变得更加复杂；
 * ·尽量避免对具有大量函数体的函数进行内联，这样会导致过多的字节码数量；
 *
 * ·一旦一个函数被定义为内联函数，便不能获取闭包类的私有成员，除非你把它们声明为internal。
 */

/**
 * 3.noinline：避免参数被内联
 *
 * 如果在一个函数的开头加上inline修饰符，那么它的函数体及Lambda参数都会被内联。然而现实中的情况比较复杂，
 * 有一种可能是函数需要接收多个参数，但我们只想对其中部分Lambda参数内联，其他的则不内联，
 */

inline fun foo3(block: () -> Unit, noinline block2: () -> Unit) {
    println("before block")
    block()
    block2()
    println("after block")
}

/**
 * 4.非局部返回
 *localReturn执行后，其函数体中的return只会在该函数的局部生效，所以localReturn（）之后的println函数依旧生效
 */

fun localReturn() {
    return
}

fun foo4() {
    println("before local return")
    localReturn()
    println("after local return")
    return
}


inline fun foo5(returning: () -> Unit) {
    println("before local return")
    returning()
    println("after local return")
    return
}

/**
 * 使用标签实现Lambda非局部返回
 */

//TODO 此处使用便签不能局部返回
fun foo6(returning: () -> Unit) {
    println("before local return")
    returning()
    println("after local return")
    return
}

/**
 * 7.crossinline
 * 值得注意的是，非局部返回虽然在某些场合下非常有用，但可能也存在危险。因为有时候，
 * 我们内联的函数所接收的Lambda参数常常来自于上下文其他地方。为了避免带有return的Lambda参数产生破坏
 * ，我们还可以使用crossinline关键字来修饰该参数，从
 */
//fun foo7(crossinline returning: () -> Unit) {
//    println("before local return")
////    returning()
//    println("after local return")
//    return
//}

/**
 * reified 具体化参数类型
 */


class Intent<T, U> constructor(val activity: Activity, clazz: Class<T>)

private class Activity {}

val activity = Activity()

fun <T>startActivity(intent: Intent<Activity,T>) {}
//
//inline fun <U:Class,reified T:Activity> Activity.start() {
//    startActivity<Activity>(Intent(activity,T::class.java))
//}


fun main() {
//    println(myCalculate(1, 2))
//    foo {
//        println("dive into kotlin")
//    }
//
//    foo2 {
//        println("dive2 into kotlin")
//    }
//
//    println("============")

    val block = { println("block") }
    val block2 = { println("block2") }

//    foo3(block){
//        block2
//    }

//    foo3(block, block2)

//    foo4()

//     foo5(return)


//    foo5{return}

//    foo6 { return@foo6}

}