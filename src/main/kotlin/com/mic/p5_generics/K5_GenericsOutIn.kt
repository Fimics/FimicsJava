package com.mic.p5_generics


/**
 * 协变与逆变 与不变
 *
 * in和out是一个对立面，其中in代表泛型参数类型逆变，out代表泛型参数类型协变。
 * 从字面意思上也可以理解，in代表着输入，而out代表着输出。但同时它们又与泛型不变相对立，
 * 统称为型变，而且它们可以用不同方式使用。
 */

/**
 * 1
 * out 声明处型变
 * 这种方式是在声明处型变，另外还可以在使用处型变，比如上面例子中sortWith方法。
 * 在了解了泛型变形的原理后，我们来看一下泛型变形到底在什么地方发挥了它最大的用处
 */
private interface Collection<out E>{}
private interface List<out E> :Collection<E>{}

/**
 * 2.
 * 假设现在有个场景，需要将数据从一个Double数组拷贝到另一个Double数组，我们该怎么实现呢?
 */

// TODO in out 两个版本怎么实现？


/**
 * 3
 * 我们所说的泛型变形或者不变都是在一种前提下的讨论，那就是你需要知道泛型参数是什么类型或者哪一类类型，
 * 比如它是String或者是Number及其子类型的。如果你对泛型参数的类型不感兴趣，那么你可以使用类型通配符来代替泛型参数。
 * 前面已经接触过Java中的泛型类型通配符“？”，而在Kotlin中则用“*”来表示类型通配符。
 */


fun main(){

    //3.Kotlin中则用“*”来表示类型通配符
    val list:MutableList<*> = mutableListOf(1,"kotlin")
//    list.add(2.0) //出错

    /**
     * 这个列表竟然不能添加，不是说好是通配吗？按道理应该可以添加任意元素。其实不然，MutableList<*>与MutableList<Any？>不是同一种列表，
     * 后者可以添加任意元素，而前者只是通配某一种类型，但是编译器却不知道这是一种什么类型，所以它不允许向这个列表中添加元素，因为这样会导致类型不安全。
     * 不过细心的读者应该发现前面所说的协变也是不能添加元素，那么它们两者之间有什么关系呢？其实通配符只是一种语法糖，
     * 背后上也是用协变来实现的。所以MutableList<*>本质上就是MutableList<outAny？>，使用通配符与协变有着一样的特性。
     */

}