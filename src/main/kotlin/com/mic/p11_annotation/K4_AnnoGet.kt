package com.mic.p11_annotation

// 1.同时和Java一样，注解的参数只能是常量，并且仅支持下列类型：·与Java对应的基本类型；·字符串；·Class对象（KClass或者Java的Class）；
//TODO 精确控制注解位 @property:CacheKey 注解用于文件  62%处
annotation class Cache(val namespace: String, val expires: Int)
annotation class CacheKey(val keyName: String, val buckets: IntArray)

@Cache(namespace = "hero", expires = 3600)
data class Hero(
    @property:CacheKey(keyName = "heroName", buckets = intArrayOf(1, 2, 3))
    val name: String,
    @field:CacheKey(keyName = "atk", buckets = intArrayOf(1, 2, 3))
    val attack: Int,
    @get:CacheKey(keyName = "def", buckets = intArrayOf(1, 2, 3))
    val defense: Int,
    val initHp: Int
)

/**
 * 2.注解获取
 * 2.1 通过反射获取
 * 2.2 注解处理器获取
 */

fun main(){
    //反射获取
    val cacheAnno = Hero::class.annotations.find { it is Cache } as Cache?
    println("namespace ${cacheAnno?.namespace}")
    println("expires ${cacheAnno?.expires}")

    //注解处理器实现
}