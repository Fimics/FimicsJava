package com.mic.core

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.GlobalScope.coroutineContext
import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.startCoroutine


fun main() {

}

 val context1: CoroutineContext = CoroutineName("co-01")+ CoroutineExceptionHandler { coroutineContext, throwable ->
     println(coroutineContext)
     println(throwable)
 }

val continuation1= suspend {
    println("in continuation")
    println("InCoroutine[${coroutineContext[CoroutineName]}].")
    5/0
}.startCoroutine(object :Continuation<Int>{

    //绑定自己的context
    override val context: CoroutineContext= context1

    override fun resumeWith(result: Result<Int>) {
        result.onFailure {
            println("onFailure")
        }

        result.onSuccess {
            println("onSuccess")
        }
    }
})
//coroutineContext +=CoroutineName("core-o1")