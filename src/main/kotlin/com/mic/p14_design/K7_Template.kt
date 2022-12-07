package com.mic.p14_design

/**
 * 模板方法模式，高阶函数代替继承
 */

//java 模式实现
abstract class CivicCenterTask {
    fun execute() {
        linUp();
        evaluate()
        askForHelp()
    }

    private fun linUp() {
        println("linUp")
    }

    private fun evaluate() {
        println("evaluate")
    }

    abstract fun askForHelp()
}

class PullSocialSecurity : CivicCenterTask() {
    override fun askForHelp() {
        println("PullSocialSecurity")
    }
}

//kotlin 模式实现
private class CivicCenterTask1 {
    fun execute(askForHelp:()->Unit) {
        this.linUp();
        this.evaluate()
        askForHelp()
    }

    private fun linUp() {
        println("linUp")
    }

    private fun evaluate() {
        println("evaluate")
    }
}

fun PullSocialSecurity1(){
    println("PullSocialSecurity1")
}

fun main() {
    val pullSocialSecurity = PullSocialSecurity()
    pullSocialSecurity.execute()

    CivicCenterTask1().execute(::PullSocialSecurity1)
}