package com.mic.coroutines

fun main(args:Array<String>) {
    test(5, action = {
        println("hello world")
    })

    test2(5, action = {
        println(it)
        println("hello world")
    })

    test(5, ::test3)

    test2(5, ::test4)

    test5(5, ::test6)


//    test5(5, action = {
//        println("a")
//    })
//
}


fun test(x: Int, action: () -> Unit) {

}

fun test2(x: Int, action: (Int) -> Unit) {

}

fun test3() {

}

fun test4(x: Int) {

}

fun test5(x: Int, action: (Int, Int) -> Unit) {
    action(1, 2)
}

fun test6(x: Int, y: Int) {
    println(x + y)
}


