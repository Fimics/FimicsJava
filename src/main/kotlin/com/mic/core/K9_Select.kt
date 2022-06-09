package com.mic.core

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.selects.select
import java.util.Random

//1. 复用多个await
data class User(val name:String)
data class Response(var user: User,var boolean: Boolean)

class GithubApi{
    suspend fun getUserSuppend(login: String){}

}

fun CoroutineScope.getUserFormApi(login: String)= async(Dispatchers.IO) {
    println("getUserFormApi")
}

fun CoroutineScope.getUserFormLocal(login: String) = async(Dispatchers.IO){
    println("getUserFormLocal")
}

//2.利用多个Channel
val channels = List(10){Channel<Int>()}
suspend fun channels(){


    GlobalScope.launch {
        delay(100)
        channels[Random().nextInt(10)].send(200)
    }

    val result = select<Int?> {
        channels.forEach { channel ->
            channel.onReceive{it}
            //or
        }
    }

    println(result)
}

//3.SelectClause
suspend fun mSelectClause(){
    select<Unit> {
        job.onJoin{
            println("join resumed")
        }
    }
}

//3.1 复用两个参数的send SelectClause2
//如果大家想要确认挂起函数是否支持select，只需要查看其是否存在对应的SelectClauseN类型可
//
suspend fun mSelectClause2(){
    List(100){ element->
        select <Unit>{
            channels.forEach { channel ->
                channel.onSend(element){ sendChannel->
                    println(" sent on $sendChannel")
                }
            }
        }
    }
}



suspend fun main() {
    //1
//    GlobalScope.launch {
//        val login=""
//        val localDeferred = getUserFormLocal(login)
//        val remoteDeferred = getUserFormApi(login)
//
//        val userResponse = select<Response<User?>> {
//            localDeferred.onAwait{Response(it.true)}
//            remoteDeferred.onAwait{Response(it,false)}
//        }
//    }.join()

    //2
//    channels()
    //3
//    mSelectClause()
    mSelectClause2()
}