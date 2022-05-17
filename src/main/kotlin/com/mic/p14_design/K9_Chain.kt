package com.mic.p14_design

/**
 * 责任链模式
 * //TODO 偏函数实现责任链
 */

data class ApplyEvent(val money: Int, val title: String)

interface ApplyHandler {
    val successor: ApplyHandler?
    fun handleEvent(event: ApplyEvent)
}

class GroupLeader(override val successor: ApplyHandler?) : ApplyHandler {
    override fun handleEvent(event: ApplyEvent) {
        when {
            event.money <= 100 -> println("GroupLeader handled application:${event.title}.")
            else -> when (successor) {
                is ApplyHandler -> successor.handleEvent(event)
                else -> println("GroupLeader:This application cannot be handdle.")
            }
        }
    }
}

class President(override val successor: ApplyHandler?) : ApplyHandler {
    override fun handleEvent(event: ApplyEvent) {
        when {
            event.money <= 500 -> println("President handled application:${event.title}.")
            else -> when (successor) {
                is ApplyHandler -> successor.handleEvent(event)
                else -> println("President:This application cannot be handdle.")
            }
        }
    }
}

class College(override val successor: ApplyHandler?) : ApplyHandler {
    override fun handleEvent(event: ApplyEvent) {
        when {
            event.money > 1000 -> println("College:This application is refused.")
            else -> println("College handled application:${event.title}.")
        }
    }
}

/**
 * 1.实现偏函数类型：PartialFunction
 * 偏函数
 * 偏函数是个数学中的概念，指的是定义域X中可能存在某些值在值域Y中没有对应的值。
 * 为了方便理解，我们可以把偏函数与普通函数进行比较。在一个普通函数中，
 * 我们可以给指定类型的参数传入任意该类型的值，比如（Int）>Unit，可以接收任何Int值。
 * 而在一个偏函数中，指定类型的参数并不接收任意该类型的值，比如：
 */

fun mustGreaterThan5(x:Int):Boolean{
    if (x>5){
        return true
    }else throw Exception("x must be greator than 5")
}


fun main(args:Array<String>){
    val college= College(null)
    val president= President(college)
    val groupLeader= GroupLeader(president)

    groupLeader.handleEvent(ApplyEvent(10,"buy a pen"))
    groupLeader.handleEvent(ApplyEvent(200,"team building"))
    groupLeader.handleEvent(ApplyEvent(600,"hold a debate match"))
    groupLeader.handleEvent(ApplyEvent(1200,"annual meeting of the college"))
}
