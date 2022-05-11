package com.mic.io

import java.io.IOException
import java.net.InetSocketAddress
import java.nio.ByteBuffer
import java.nio.channels.SelectionKey
import java.nio.channels.Selector
import java.nio.channels.ServerSocketChannel
import java.nio.channels.SocketChannel

/**
 * NIO服务端
 */
class NIOServer {
    // 通道管理器
    private var selector: Selector? = null

    /**
     * 获得一个ServerSocket通道，并对该通道做一些初始化的工作
     *
     * @param port
     * 绑定的端口号
     * @throws IOException
     */
    @Throws(IOException::class)
    fun initServer(port: Int) {
        // 获得一个ServerSocket通道
        val serverChannel = ServerSocketChannel.open()
        // 设置通道为非阻塞
        serverChannel.configureBlocking(false)
        // 将该通道对应的ServerSocket绑定到port端口
        serverChannel.socket().bind(InetSocketAddress(port))
        // 获得一个通道管理器
        selector = Selector.open()
        // 将通道管理器和该通道绑定，并为该通道注册SelectionKey.OP_ACCEPT事件,注册该事件后，
        // 当该事件到达时，selector.select()会返回，如果该事件没到达selector.select()会一直阻塞。
        serverChannel.register(selector, SelectionKey.OP_ACCEPT)
    }

    /**
     * 采用轮询的方式监听selector上是否有需要处理的事件，如果有，则进行处理
     *
     * @throws IOException
     */
    @Throws(IOException::class)
    fun listen() {
        println("服务端启动成功！")
        // 轮询访问selector
        while (true) {
            // 当注册的事件到达时，方法返回；否则,该方法会一直阻塞
            selector!!.select()
            // 获得selector中选中的项的迭代器，选中的项为注册的事件
            val ite: MutableIterator<*> = selector!!.selectedKeys().iterator()
            while (ite.hasNext()) {
                val key = ite.next() as SelectionKey
                // 删除已选的key,以防重复处理
                ite.remove()
                handler(key)
            }
        }
    }

    /**
     * 处理请求
     *
     * @param key
     * @throws IOException
     */
    @Throws(IOException::class)
    fun handler(key: SelectionKey) {

        // 客户端请求连接事件
        if (key.isAcceptable) {
            handlerAccept(key)
            // 获得了可读的事件
        } else if (key.isReadable) {
            handlerRead(key)
        }
    }

    /**
     * 处理连接请求
     *
     * @param key
     * @throws IOException
     */
    @Throws(IOException::class)
    fun handlerAccept(key: SelectionKey) {
        val server = key.channel() as ServerSocketChannel
        // 获得和客户端连接的通道
        val channel = server.accept()
        // 设置成非阻塞
        channel.configureBlocking(false)

        // 在这里可以给客户端发送信息哦
        println("新的客户端连接")
        // 在和客户端连接成功之后，为了可以接收到客户端的信息，需要给通道设置读的权限。
        channel.register(selector, SelectionKey.OP_READ)
    }

    /**
     * 处理读的事件
     *
     * @param key
     * @throws IOException
     */
    @Throws(IOException::class)
    fun handlerRead(key: SelectionKey) {
        // 服务器可读取消息:得到事件发生的Socket通道
        val channel = key.channel() as SocketChannel
        // 创建读取的缓冲区
        val buffer = ByteBuffer.allocate(1024)
        val read = channel.read(buffer)
        if (read > 0) {
            val data = buffer.array()
            val msg = String(data).trim { it <= ' ' }
            println("服务端收到信息：$msg")

            //回写数据
            val outBuffer = ByteBuffer.wrap("好的".toByteArray())
            channel.write(outBuffer) // 将消息回送给客户端
        } else {
            println("客户端关闭")
            key.cancel()
        }
    }

    companion object {
        /**
         * 启动服务端测试
         *
         * @throws IOException
         */
        @Throws(IOException::class)
        @JvmStatic
        fun main(args: Array<String>) {
            val server = NIOServer()
            server.initServer(8000)
            server.listen()
        }
    }
}