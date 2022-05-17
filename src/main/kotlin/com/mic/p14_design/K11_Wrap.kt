package com.mic.p14_design

/**
 * 包装模式
 */
interface MacBook {
    fun getCost(): Int
    fun getDesc(): String
    fun getProdDate(): String
}

class MacBookPro : MacBook {
    override fun getCost() = 10000
    override fun getProdDate() = "Late 2011"
    override fun getDesc() = "MacBook Pro"
}

class Wrap(val macbook: MacBook) : MacBook by macbook {
    override fun getCost() = macbook.getCost() + 10000
    override fun getDesc() = macbook.getDesc() + "1G Memory"
}

//2.通过扩展代替装饰
class Printer {
    fun drawLine() = println("drawLine")
    fun drawDottedLine() = println("drawDottedLine")
    fun drawStars() = println("drawStars")
}

fun Printer.startDraw(decorated: Printer.()->Unit){
    println("+++start drawing+++")
    this.decorated()
    println("+++end drawing+++")
}

fun main() {
    val macBookPro = MacBookPro()
    val warp = Wrap(macBookPro)
    println(warp.getDesc())
    println(warp.getCost())
    println(warp.getProdDate())

    Printer().run {
        startDraw {
            drawLine()
        }
    }
}