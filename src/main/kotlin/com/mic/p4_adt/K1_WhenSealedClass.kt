package com.mic.p4_adt

/**
 * 和类型？
 * 积类型
 */

private sealed class Day{
    class SUN:Day()
    class MON:Day()
    class TUE:Day()
    class WED:Day()
    class THU:Day()
    class FRI:Day()
    class SAT:Day()
}

sealed class Shape{
    class Circle(val radius:Double):Shape()
    class Rectangle(val width:Double,val height:Double):Shape()
    class Triangle(val base:Double,val height:Double):Shape()
}

fun getArea(shape:Shape):Double=when(shape){
    is Shape.Circle->Math.PI*shape.radius*shape.radius
    is Shape.Rectangle->shape.width*shape.height
    is Shape.Triangle->shape.base*shape.height/2.0
}


private fun schedule(day: Day){

    /**
     * 使用密封类，或者说和类型最大的好处就是，当我们使用when表达式时不用去考虑非法的情况了，
     * 也就是可以省略else分支。因为和类型是类型安全的，我们只需要将可能的情况列出来即可。
     * 另外，如果我们遗漏了某种情况或者说多添加了额外的情况，编译器会报错的。
     */
    when(day){
       is Day.SUN ->{

        }

        is Day.SUN->{

        }
    }
}

fun main(){



}