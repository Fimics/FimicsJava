package com.mic.p3_oop

// 可见性 visibility
// Kotlin提供了4种可见性修饰符：private, protected, internal(这个和java不一样，其他的和java中一样), public
//kotlin 修饰符不写的话 默认是public的
// internal 只能在同一个模块(module)下使用

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