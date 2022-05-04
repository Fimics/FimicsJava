package com.mic.p1_base

/**
 * 标签处返回
 */

fun main(){

    /**
     * 定义标签 loop@
     */

    loop@ for (i in 1..4){
        second@ for (j in 1..4){

            //break 到指定标签
            if(i==2 && j==2){

//                break@loop   //跳出第一层loop （整个循环）
                break@second//跳出第二层loop
            }
            println(" i = $i, j = $j")
        }
    }
}