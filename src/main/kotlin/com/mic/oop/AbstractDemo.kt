package com.mic.oop

open class BaseClass {

    open fun method() {

    }
}

abstract class ChildClass: BaseClass() {

   abstract override fun method()
}
