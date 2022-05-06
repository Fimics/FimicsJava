package com.mic.p1_base
//导入其他文件
//import com.mic.test.multiply;

/**
 * 低功耗蓝牙(BLE)协议栈
 * https://blog.csdn.net/qq_25727979/article/details/122110355
 */

/**
 * 给导入的文件起别名
 */
import com.mic.test.multiply as mu;

fun main(){
    //val 定义常量 ，相当于java中final修饰的
   val a:Int=1;
//    a=4

    var b:Int=5;
    var c = a+b;
    c.toString()
    println("c=${c}")

    var x =10;
    var y:Byte=20;
     //不允许byte类型赋值给int,(小范围赋值给大范围 可以使用y.toInt)
//    x=y;


    println(mu(2,4))

    val m = intArrayOf(1,2,3);
    //此处m的值不能变了
//    m = intArrayOf(3,4,5)
      m.set(0,5)

     m.forEach {i->
     println(i)
 }

}