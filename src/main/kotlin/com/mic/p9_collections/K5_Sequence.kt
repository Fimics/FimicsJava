package com.mic.p9_collections

/**
 * 通过序列提高效率
 * filter方法和map方法都会返回一个新的集合，也就是说上面的操作会产生两个临时集合，
 * 因为list会先调用filter方法，然后产生的集合会再次调用map方法。如果list中的元素非常多，
 * 这将会是一笔不小的开销。为了解决这一问题，序列（Sequence）就出现了。
 */

//val list = listOf(listOf("jilen", "shaw", "lisa"), listOf("yison", "pan"), listOf("jack"))
//
//private data class Student(val name: String, val age: Int, val sex: String, val score: Int, val hobbies: List<String>)
//
//private val jilen = Student("Jilen", 30, "m", 85, listOf("coding", "reading"))
//private val shaw = Student("Shaw", 18, "m", 90, listOf("drinking", "fishing"))
//private val yison = Student("Yison", 40, "f", 59, listOf("running", "game"))
//private val jack = Student("Jack", 30, "m", 70, listOf("drawing"))
//private val lisa = Student("Lisa", 25, "f", 88, listOf("writing"))
//private val pan = Student("Pan", 36, "f", 55, listOf("dancing"))
//
//private val students = listOf(jilen, shaw, yison, jack, lisa, pan)


//list.filter{ it > 2 }.map{ it * 2 }

/**
 * 在编程语言理论中，惰性求值（LazyEvaluation）表示一种在需要时才进行求值的计算方式。
 * 在使用惰性求值的时候，表达式不在它被绑定到变量之后就立即求值，而是在该值被取用时才去求值。
 * 通过这种方式，不仅能得到性能上的提升，还有一个最重要的好处就是它可以构造出一个无限的数据类型。
 * 通过上面的定义我们可以简单归纳出惰性求值的两个好处，一个是优化性能，另一个就是能够构造出无限的数据类型。这里只需要先知道这个概念
 */

fun main(){
    val list = listOf(1, 2, 3, 4, 5)
    list.asSequence().filter { it > 2 }.map { it*2 }.toList().forEach { println(it) }

}