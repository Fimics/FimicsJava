package com.mic.io

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.net.ServerSocket
import java.net.Socket
import java.util.concurrent.Executors
//同步阻塞的BIO
fun main() {

    val threadPool = Executors.newCachedThreadPool()
    val server = ServerSocket(9000)
    println("server starting...")
    while (true) {
        //获取一个套接字（阻塞）
        val socket = server.accept()
        threadPool.execute {
            handlerSocket(socket)
        }
    }
}

private fun handlerSocket(socket: Socket) {

    try {
        val bytes = ByteArray(1024)
        val inputStream = socket.getInputStream()
        while (true) {
            //读取数据（阻塞）

            val bufferReader = BufferedReader(InputStreamReader(inputStream))
            println(bufferReader.readLine())
        }
    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        try {
            println("socket closed")
            socket.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}


