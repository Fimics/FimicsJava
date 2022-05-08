package com.mic.p4_adt

/**
 * 模式匹配
 *
 * 1.常量模式（）用when来操作枚举类是一样的，都是匹配常量
 * fun constantPattern(a:Int)=when(a){
 * 1->"Itis1"
 * 2->"Itis2"
 * else->"It is other number"
 * }
 *
 * 2.类型匹配  K1里的shape 三种类型 类型模式其实类似于我们在Java中使用的istanceof方法，
 *
 * 3.逻辑表达式匹配
 *  fun logicPattern(a:String)=when{
 *  a.contains("Yison")->"Something is a bout Yison"
 *  else->"It`s none of Yison`s business"
 *  }
 *
 *  4.处理嵌套表达式
 *
 *  5.类型测试 instanceOf Kotlin 会自动转型
 *
 *  6.面向对象分解 TODO
 *
 *  7.访问者模式  见 designpatterns K11  TODO
 *
 */

/**
 * 4.2.3　4.2.5 处理嵌套表达式
 */
sealed class Expr{
    data class Num(val value: Int):Expr()
    data class Operate(val opName:String,val left:Expr,val right:Expr):Expr()
}

fun simplifyExpr(expr:Expr):Expr=when(expr){
    is Expr.Num->expr
    is Expr.Operate->when(expr){
        Expr.Operate("+",Expr.Num(0),expr.right)-> simplifyExpr(expr.right)
        Expr.Operate("+",expr.left,Expr.Num(0))-> simplifyExpr(expr.left)
        else->expr
    }
}


fun main(){

}