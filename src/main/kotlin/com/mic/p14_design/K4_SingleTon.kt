package com.mic.p14_design

//饿汉模式(1)
object SingleTon {
    fun get(): SingleTon {
        return this
    }
    fun printx() {
        println(this)
    }
}

//dcl模式(2)
class Instance private constructor() {

    fun add(){}

    companion object {
        @Volatile
        private var instance: Instance? = null

        val getInstance: Instance?
            get() {
                if (instance == null) {
                    synchronized(Instance::class.java) {
                        if (instance == null) {
                            instance = Instance()
                        }
                    }
                }
                return instance
            }
    }
}

//静态内部类方式(Holder) (3)
class Instance2 private constructor() {

    private object Holder {
        val INSTANCE = Instance2()
    }

    companion object {
        val instance: Instance2 get() = Holder.INSTANCE
    }
    fun add() {}
}


fun main() {
    val singleton = SingleTon.get()
    SingleTon.printx()

    val instance = Instance.getInstance
    instance?.add()

    val instance2 = Instance2.instance
    instance2.add()
}


