package com.mic.p9_collections


val list = listOf(listOf("jilen", "shaw", "lisa"), listOf("yison", "pan"), listOf("jack"))

private data class Student(val name: String, val age: Int, val sex: String, val score: Int, val hobbies: List<String>)

private val jilen = Student("Jilen", 30, "m", 85, listOf("coding", "reading"))
private val shaw = Student("Shaw", 18, "m", 90, listOf("drinking", "fishing"))
private val yison = Student("Yison", 40, "f", 59, listOf("running", "game"))
private val jack = Student("Jack", 30, "m", 70, listOf("drawing"))
private val lisa = Student("Lisa", 25, "f", 88, listOf("writing"))
private val pan = Student("Pan", 36, "f", 55, listOf("dancing"))

private val students = listOf(jilen, shaw, yison, jack, lisa, pan)


fun main() {
    println(list.flatten())

    var list2 = list.toMutableList()
    val flatmapList = list2.map {
            "flat map ->$it"
    }

    println(flatmapList)

    val hobbies = students.map { it.hobbies }.flatten()
    println(hobbies)

    val hobbies1 = students.flatMap { it.hobbies }
    println(hobbies1)
}
