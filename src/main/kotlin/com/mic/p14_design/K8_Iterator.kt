package com.mic.p14_design

/**
 * iterator 迭代器模式
 */
data class Book(val name: String)

//1.实现iterator接口
class Bookcase(val books: List<Book>) : Iterator<Book> {

    private var iterator: Iterator<Book> = books.iterator()
    override fun hasNext() = this.iterator.hasNext()

    override fun next() = this.iterator.next()
}

//2.重载iterator方法
private class Bookcase1(val books: List<Book>) {
    //TODO 怎么理解？？？
    operator fun iterator(): Iterator<Book> = this.books.iterator()
}

//3.通过扩展函数实现

operator fun Bookcase.iterator():Iterator<Book> = books.iterator()

fun main() {
    //1.实现iterator接口
    val bookList = listOf<Book>(Book("java"), Book("c"), Book("python"), Book("android"))
//    val bookcase = Bookcase(bookList)
//    while (bookcase.hasNext()){
//        println(bookcase.next().name)
//    }

    //2.重载iterator方法
//    val bookcase1 = Bookcase1(bookList)
//    val iterator = bookcase1.iterator()
//    while (iterator.hasNext()) {
//        println(iterator.next().name)
//    }
}