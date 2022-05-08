package com.mic.p3_oop

/**
 * 可见性 visibility
 *Kotlin提供了4种可见性修饰符：private, protected, internal(这个和java不一样，其他的和java中一样), public
 *kotlin 修饰符不写的话 默认是public的
 *internal 只能在同一个模块(module)下使用
 * 而Kotlin默认并没有采用这种包内可见的作用域，而是使用了模块内可见，模块内可见指的是该类只对一起编译的其他Kotlin文件可见。
 * 开发工程与第三方类库不属于同一个模块，这时如果还想使用该类的话只有复制源码一种方式了。这便是Kotlin中internal修饰符的一个作用体现。
 */


fun method() {

}



open class Clazz {

    private val b = 3;

    protected open val c = 4;

    internal val d = 5;
}

class subClazz: Clazz() {

}

class Clazz2 {

}