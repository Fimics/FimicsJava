package com.mic.oop

open class BaseClass {

    open fun method() {

    }
}

abstract class ChildClass: BaseClass() {

    override abstract fun method()
}
