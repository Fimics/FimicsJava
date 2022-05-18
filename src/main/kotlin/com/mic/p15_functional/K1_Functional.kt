package com.mic.p15_functional

sealed class Format

data class Print(val text: String) : Format()

object NewLine : Format()

val string = listOf<Format>(Print("Hello"), NewLine, Print("Kotlin"))

fun unsafeInterpreter(strs: List<Format>) {
    strs.forEach {
        when (it) {
            is Print -> println(it.text)
            is NewLine -> println("new line")
        }
    }
}

//纯函数方式
fun stringInterpreter(str:List<Format>)= str.fold(""){ text,s->
    when(s){
        is Print ->  text+s.text
        is NewLine -> text+"\n"
    }
}


fun main() {
//    unsafeInterpreter(string)
      stringInterpreter(string)
}