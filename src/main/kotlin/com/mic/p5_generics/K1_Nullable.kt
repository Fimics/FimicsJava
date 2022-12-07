package com.mic.p5_generics

/**
 * 可空类型
 */

data class Seat(val student: Student?)
data class Student(val glasses: Glasses?)
data class Glasses(val degreeOfMyopia: Double)


fun main() {

    //1.安全调用?.
    //println("该位置上学生眼镜度数：${s.student?.glasses?.degreeOfMyopia}")
    // 这里的“？.”我们可以将其称作安全调用。当student存在时，才会调用其下的glasses。

    //2.2.Elvis操作符？：
    //假设座位上有学生，如果不戴眼镜，眼镜度数为1。
    //va lresult=student.glasses？.degreeOfMyopia?:1

    //3.非空断言！！.
    //val result=student!!.glasses
    // 当这个学生不戴眼镜时，程序就会抛出NPE的异常。除此之外还有“！is”“as？”等运算符，

    //4.@Nullable
    //Kotlin在方法参数上标注了@Nullable，在实现上，依旧采用了if..else来对可空情况进行判断。
}