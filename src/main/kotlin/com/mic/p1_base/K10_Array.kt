package com.mic.p1_base

//https://www.jianshu.com/p/97d6f55dd4c3  Kotlin-数组与集合-Array

/**
 * 1.Kotlin中Array并不是一种原生的数据结构，而是一种Array类，甚至我们可以将Kotlin中的Array视作集合类的一部分。
 *
 * 2.在Kotlin中，还为原始类型额外引入了一些实用的类：IntArray、CharArray、ShortArray等，
 * 分别对应Java中的int[]、char[]、short[]等。
 *
 * IntArray等并不是Array的子类，所以用两者创建的相同值的对象，并不是相同对象。
 * 由于Kotlin对原始类型有特殊的优化（主要体现在避免了自动装箱带来的开销），所以我们建议优先使用原始类型数组。
 *
 * 若你熟悉Java，你应该知道数组的一些特性：
 * ·数组大小固定，并且同一个数组只能存放类型一样的数据（基本类型/引用类型）；
 * ·数组在内存中地址是连续的，所以性能比较好。
 * 因为数组大小固定，所以限制了很多使用场景。我们通常采用可自动扩容的集合，
 */
fun main(args: Array<String>) {
    var myarray = arrayOf(1,2,4,"hello")
    var m1 :Array<Int> =  Array(1){0};
//    m1[0]=0
//    m1[1]=1
    for ( i in m1){
        println(m1[i])
    }

    for (a in myarray){
        when(a){
            1,2,4-> println("数字")
            is String-> println("字符串")
        }
    }


    println("------------indices-------")
    for(i in myarray.indices){
        println(myarray[i])
    }


    println( "----withIndex---")
    for((index,value) in myarray.withIndex()){
        println("the element at $index is $value")
    }

}
