package com.mic.core

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlin.coroutines.CoroutineContext

//1。全局异常处理
class GlobalExceptionHandler:CoroutineExceptionHandler{
    override val key: CoroutineContext.Key<*>
        get() = CoroutineExceptionHandler

    override fun handleException(context: CoroutineContext, exception: Throwable) {
        println("GlobalExceptionHandler")
    }
}

//2.channel


fun main() {

}