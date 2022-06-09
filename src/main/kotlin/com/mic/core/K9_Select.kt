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

suspend fun channels(){
    val channels = List(10){Channel<Int>()}

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

//.SelectClause
suspend fun mSelectClause(){
    select<Unit> {
        job.onJoin{
            println("join resumed")
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
    mSelectClause()
}