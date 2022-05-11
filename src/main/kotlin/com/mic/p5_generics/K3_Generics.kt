package com.mic.p5_generics


/**
 *  设定上界与Where
 *  Where :T A,T:B
 * 功能
 * 1.类型检查，能在编译时就帮你检查出错误；
 * 2.更加语义化，比如我们声明一个List<String>，便可以知道里面存储的是String对象，而不是其他对象；
 * 3.自动类型转换，获取数据时不需要进行类型强制转换；
 * 4.能写出更加通用化的代码
 */

//1.
class SmartList<T> : ArrayList<T>() {

    fun find(t: T): T? {
        val index = super.indexOf(t)
        return if (index >= 0) super.get(index) else null
    }

    //val arrayList = ArrayList() kotlin 不允许 但java可以

    val arrayList = arrayListOf("java", "python")
}

//2.
fun <T> ArrayList<T>.find(t: T): T? {
    val index = this.indexOf(t)
    return if (index > 0) this.get(index) else null
}

//3.PE(T extends A(上界约束))CS(T super A(下界约束))
class Plate<T>(t: T)
open class Fruit1(val weight: Double)
//T:Fruit? 这与kotlin变量的可空保持了一致性
//class FruitPlate<T:Fruit?>(val t: T)

/**
 * 4.
 * 有多个条件限制怎么处理，假设有一把刀用来切长在地上的水果(如西瓜) ,可以这样实现
 */

interface Ground {}
class WaterMelon(weight: Double) : Fruit1(weight), Ground

fun <T> cut(t: T) where T : Fruit1, T : Ground {
    println("You can cut me.")
}

fun main() {

    //Test SmartList

    val smartList = SmartList<String>()
    smartList.add("one")
    println(smartList.find("one"))
    println(smartList.find("two").isNullOrEmpty())

    //4.
    cut(WaterMelon(3.0))
//    cut(Fruit1(2.0))

}


