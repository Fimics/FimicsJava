package com.mic.p11_annotation

import kotlin.reflect.KProperty
import kotlin.reflect.full.memberProperties

data class User(val name: String, val age: Int)


fun toMap(user: User): Map<String, Any> {
    return hashMapOf("name" to user.name, "age" to user.age)
}

object Mapper {
    fun <A : Any> toMap2(a: A): Map<String, Any?> {
        var result = a::class.memberProperties.map { m ->
            val p = m as KProperty<*>
            //KProperty的call函数实际上是直接调用Getter，这是更合理的方案。
            p.name to p.call(a)
        }.toMap()
        return result
    }
}


fun main() {

    val user = User("zhangsan", 20)
    println(toMap(user))

    println(Mapper.toMap2(user))

}
