package com.mic.p8_lambda

/**
 * Kotlin 中 let、apply、run、with及 also 的差别
 * https://www.jianshu.com/p/27ad898d263b
 */


/**
 * let
 * let 函数是参数化类型 T 的扩展函数。在 let 块内可以通过 it 指代该对象。返回值为 let 块的最后一行或指定 return 表达式
 * public inline fun <T, R> T.let(block: (T) -> R): R
 */

class Book {
    var name = "<<数据结构>>"
    var price = 60
    fun displayInfo() = println("Book name :$name and price :$price")
}



fun main() {
    //let 块中的最后一条语句如果是非赋值语句，则默认情况下它是返回语句，反之，则返回的是一个 Unit 类型。
//    val book=Book().let {
//        it.name="计算机网络"
//        it.price=40
////        "This book is ${it.name}"
//    }
//
//    println(book)

    /**
     *let 可用于空安全检查。
     *设置 name 为一个可空字符串，利用 name?.let 来进行空判断，只有当 name 不为空时，逻辑才能走进 let 函数块中。
     * 在这里，我们可能还看不出来 let 空判断的优势，但是当你有大量 name 的属性需要编写的时候，就能发现 let 的快速和简洁
     */

//    var name:String?=null
//    val  nameLength = name?.let {
//        it.length
//    }?:"name 为空的值"

//    println(nameLength)

    /**
     * let 可对调用链的结果进行操作。
     */

    val numbers = mutableListOf<String>("one","two","three","four","five")
//    val resultLists :List<Int> = numbers.map {
//        it.length
//    }.filter {
//        it>3
//    }
//    println(resultLists)

    /**
     * 目的是获取数组列表中长度大于 3 的值。因为我们必须打印结果，所以我们将结果存储在一个单独的变量中，
     * 然后打印它。但是使用“let”操作符，我们可以将代码修改为:
     * 使用 let 后可以直接对数组列表中长度大于 3 的值进行打印，去掉了变量赋值这一步。
     */

//    numbers.map {
//        it.length
//    }.filter {
//        it>3
//    }.let {
//        println(it)
//    }


    /**
     * let 可以将 “It” 重命名为一个可读的 lambda 参数
     * let 是通过使用“It”关键字来引用对象的上下文，因此，这个 “It” 可以被重命名为一个可读的 lambda 参数，如下将 it 重命名为 book：
     */

//    val book = Book().let { book ->
//        book.name="python"
//    }
//    println(book)

    /**
     * apply
     * public inline fun <T> T.apply(block: T.() -> Unit): T
     * apply 是 T 的扩展函数,与 run 函数有些相似，它将对象的上下文引用为 “this” 而不是 “it”，
     * 并且提供空安全检查，不同的是，apply 不接受函数块中的返回值，返回的是自己的 T 类型对象。
     *
     * apply 函数主要用于初始化或更改对象，因为它用于在不使用对象的函数的情况下返回自身
     */

//    val book = Book().apply {
//        name="java"
//        price=20
//    }
//    println(book)

    /**
     * run
     * run 函数以 “this”作为上下文对象。
     *
     *
     * run 函数存在两种声明方式。
     *1、与 let 一样，run 是作为 T 的扩展函数
     * public inline fun <T, R> T.run(block: T.() -> R): R
     *
     * 2.第二个 run 的声明方式则不同，它不是扩展函数，并且块中也没有输入值，因此，
     * 它不是用于传递对象并更改属性的类型，而是可以使你在需要表达式的地方就可以执行一个语句
     * public inline fun <R> run(block: () -> R): R
     */
//    val book = Book().run {
//        // this ==  Book() 本身
//        name = "《计算机网络》"
//        price = 40
//        displayInfo()
//        555  // 返回类型，根据匿名函数最后一行的变化而变化
//    }
//    // 返回值 = 函数块的最后一行 / return表达式
//    println(book)
//
//    run {
//        val book = Book()
//        book.name = "《计算机网络》"
//        book.price = 30
//        book.displayInfo()
//    }

    /**
     * with
     * public inline fun <T, R> with(receiver: T, block: T.() -> R): R
     *
     * with 属于非扩展函数，直接输入一个对象 receiver，当输入 receiver 后，
     * 便可以更改 receiver 的属性，同时，它也与 run 做着同样的事情。
     *
     * with 使用的是非 null 的对象，当函数块中不需要返回值时，可以使用 with。
     */
//
//    val book = Book()
//
//    val str: String = with(book) {
//        name = "《计算机网络》"
//        price = 40
//        displayInfo()
//        "dfdggg" // 返回值 = 函数块的最后一行 / return表达式
//    }
//    print(str)

    /**
     * also
     * public inline fun <T> T.also(block: (T) -> Unit): T
     *
     * also 是 T 的扩展函数，返回值与 apply 一致，直接返回 T。also
     * 函数的用法类似于 let 函数，将对象的上下文引用为 “it” 而不是 “this” 以及提供空安全检查方面。
     *
     * let函数：返回值 = 最后一行 / return的表达式
     * also函数：返回值 = 传入的对象的本身
     */
}