package com.mic.netty.server

import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.socket.nio.NioServerSocketChannel
import java.util.concurrent.Executors

fun  main(args:Array<String>){

}

class Server {
    var bootstrap:ServerBootstrap=ServerBootstrap()
    //boss线程监听端口，worker线程负责数据读写
    val boss = Executors.newCachedThreadPool()
    val worker = Executors.newCachedThreadPool()

    fun start(){
//         bootstrap.group(boss,worker)
    }

}