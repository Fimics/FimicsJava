package com.mic.p9_collections

fun main(args: Array<String>) {
    val text = """
        1.理解Kotlin集合，关键在于理解可变与不可变，指的是集合内部的元素和元素的组织方式，
          而不在于集合类型变量是val还是var可变集合，变的是元素的值、集合内元素的排列、数量等。
        3.Kotlin集合框架里，所有的可变集合都继承自相同的不可变集合。
        4.不可变集合只能对元素进行读取和查询，可变集合才能对元素进行增减和赋值。
        5.相对于Java集合，Kotlin的不可变集合只拥有一部分功能，可变集合才拥有完整的功能。
    """.trimIndent()

    println(text)
    val list1 = mutableListOf(1, 2, 3, 4)
    val list2: List<Int> = listOf(1)
    list2.toMutableList()
    val list: List<Int> = listOf(1,2,3,4,5,6,7,8,9)
//    val nothing:Nothing =get(5);
//    val nothing2:Nothing = get(10)
    println(list::class)
    //如果该集合至少有一个元素，返回 true ，否则返回 false 。
    println(list.any())
    //当且仅当该集合中所有元素都满足条件时，返回 true ；否则都返回 false 。
    println(list.all { it % 2 == 0 })
    //如果该集合没有任何元素，返回 true ，否则返回 false 。
    println(list.none())
    //reduce 从 第一项到最后一项进行累计运算
    println("reduce")
    println(list.reduce { acc, i -> acc + i })
    println(list.count())
    //带初始值的reduce
    println(list.fold(100, { total, next -> next + total }))
    //forEachIndexed 带index(下标) 的元素遍历
    println(list.forEachIndexed { index, value -> if (value > 1) println(value) })
    //max  maxBy(it*it)
//    println(list.max())
    //take(n: Int): List<T> 挑出该集合前n个元素的子集合
    println(list.take(1))
    //drop(n: Int) 去除前n个元素返回剩下的元素的子集合
    println(list.drop(1))
    //dropWhile(predicate: (T) -> Boolean) 去除满足条件的元素返回剩下的元素的 子集合
    //slice(indices: IntRange) 取开始下标至结束下标元素子集合
//    println(list.slice(0..2))
    //filterTo(destination: C, predicate: (T) -> Boolean) 过滤出满足条件的元素并 赋值给destination
    println(list.filter { it > 3 })
    //map(transform: (T) -> R): List<R> 将集合中的元素通过转换函数 transform 映射后的结果，存到一个集合中返回。
    println(list.map { it * it })
    //flatMap(transform: (T) -> Iterable<R>): List<R> 在原始集合的每个元素上调用 transform 转换函数，得到的映射结果组成的单个列表。
    //groupBy(keySelector: (T) -> K): Map<K, List<T>>
    //reversed(): List<T>
    println(list.reversed())
    //sorted 和 sortedDescending  升序排序和降序排序

    println("lastIndex")
    println(list.lastIndex)
    println("no empty")
    println("kotlin".noEmpty())

    //类型转换
    var aInt: Int = 10;
    var bLong: Long = 20
    aInt = bLong.toInt()

    var a: String? = null
    println(a?.length)
    println("null-->null")

}

fun get(index: Int): Nothing {
    throw IndexOutOfBoundsException()
}

//扩展属性
val <T> List<T>.lastIndex: Int get() = size - 1

//扩展方法
fun String.noEmpty(): Boolean {
    return !this.isEmpty()
}

fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val tmp = this[index1] // this对应该列表
    this[index1] = this[index2]
    this[index2] = tmp
}