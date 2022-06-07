package com.mic.core

import com.sun.media.jfxmediaimpl.MediaDisposer.Disposable
import javafx.application.Application.launch
import jdk.nashorn.internal.ir.Block
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.startCoroutine

//2.
//private interface Job:CoroutineContext.Element{
//    companion object Key:CoroutineContext.Key<Job>
//
//    override val key: CoroutineContext.Key<*> get() = Job
//
//    val isActive:Boolean
//
//    fun invokeOnCancel():Disposable
//
//    fun invokeOnCompletion():Disposable
//
//    fun cancel()
//
//    fun remove(disposable: Disposable)
//
//    suspend fun join()
//}

//3.


//4.
val exceptionHandler = CoroutineExceptionHandler {
        coroutineContext, throwable ->
        println("[ExceptionHandler]  ${throwable.message}")
}


suspend fun main() {

    coroutineScope {
        delay(1000)

        launch(exceptionHandler){
            println(1)
            throw  java.lang.ArithmeticException("DIV by 0")
            println(2)
        }.join()
    }



}



