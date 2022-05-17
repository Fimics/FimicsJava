package com.mic.p14_design

/**
 * 用具名可选参数而不是构建者
 */

class Robot(val code:String, private val battery:String?=null, val height:Int? = null, private val weight:Int?=null){
    init {
        require(weight==null || battery!=null){
            throw IllegalArgumentException()
        }
    }
}

fun main(){
    val robot = Robot(code = "008")
}