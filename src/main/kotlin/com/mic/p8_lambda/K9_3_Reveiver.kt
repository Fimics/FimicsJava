package com.mic.p8_lambda



/**
 * owner
 */
val sum: Int.(Int) -> Int = { other -> other + this }

val sum1 = fun Int.(other: Int):Int = this+other

val sum2 =fun Int.():Int=this
val sum3:Int.()->Unit={}


data class Bean(var title:String?, var fontSize:Int?,var content:String?=null)

inline fun<T,R> withTest(receiver:T,block:T.()->R):R{
    return receiver.block()
}

inline fun<T> T.applyTest(block: T.() -> Unit):T{
    block()
    return this;
}

inline fun<R> runTest(block: () -> R):R{
    return block()
}

inline fun<T,R> T.runTest(block: T.() -> R):R{
    return block()
}

private inline fun<T> T.alsoTest(block: (T) -> Unit):T{
      block(this)
      return this
}
private inline fun<T,R> T.letTest(block: (T) -> R):R{
    return block(this)
}

//predicate
//fun String.filter(predicate: (String?)->Boolean):Boolean {
//    return this.length>10
//}

fun main() {

    println(2.sum(4))
    println(2.sum1(4))

    val bean = Bean("extension",20,"我的测试")

    val(title,size,content)=bean

    println("title->$title   size->$size  content->$content")

//    with(bean,{
//        println("with")
//        println(title)
//    })

    with(bean){
        println(bean)
    }

    withTest(bean){
        println(bean)
    }

    bean.apply {
        val a = this.title
    }

    bean.applyTest {
        this.title = "$title -->test"
    }

    println(bean)


    bean.run {
        this.title="run"
    }
    println(bean)

    val runTest=runTest() {
        val b1 = Bean("extension  runtest",20,"我的测试")
        200
    }


    println(runTest)

    bean.alsoTest() {
        bean.title="also test"
    }


    println(bean)

   bean.letTest {
        it.title="let tet"
    }

    println(bean)


    bean.takeIf {
        it.title="take if"
        it.title?.length!! >10
    }?.let { println(it) }

    bean.takeUnless {
        it.title="takeUnless"
        it.title?.length!! >10
    }?.let { println(it) }

    repeat(20){
        Thread.sleep(1000)
        println(it)
    }

}