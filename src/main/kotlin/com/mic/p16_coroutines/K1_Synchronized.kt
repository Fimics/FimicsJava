package com.mic.p16_coroutines

import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

/**
 * 它没有synchronized，取而代之，它使用了@Synchronized注解和synchronized（）
 */


class Shop {

    //1.
    @Volatile
    private var running = false

    val goods = hashMapOf<Long, Int>()

    init {
        goods.put(1, 10)
        goods.put(2, 20)
    }

    //2.
    @Synchronized
    fun bugGoods(id: Long) {
        val stock = goods.getValue(id)
        goods.put(id, stock - 1)
    }

    //3.
    fun buyGoods2(id: Long) {
        synchronized(this) {
            val stock = goods.getValue(id)
            goods.put(id, stock - 1)
        }
    }

    //4.
    var lock: Lock = ReentrantLock()
    fun bugGoods3(id: Long) {
        lock.lock()
        try {
            val stock = goods.getValue(id)
            goods.put(id, stock - 1)
        }catch (ex:Exception){
            println("exception")
        }finally {
            lock.unlock()
        }
    }


    //5.
    fun<T> withLock(lock: Lock,action:()->T) {
        lock.lock()
        try {
            action()
        }catch (e:Exception){
            println("exception")
        }finally {
            lock.unlock()
        }
    }

    //6.
    fun kotlinWithLock(){
        lock.withLock {
            bugGoods(1)
        }
    }

}

fun main() {

}