package com.mic.p5_type_system_generics

import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 *System.out.println(appleArray.getClass());
 * System.out.println(appleList.getClass());
 * //运行结果class[Ljavat.Apple; classjava.util.ArrayList
 *
 * 1.数组在运行时是可以获取自身的类型，而List<Apple>在运行时只知道自己是一个List，而无法获取泛型参数的类型。
 * 而Java数组是协变的，也就是说任意的类A和B，若A是B的父类，则A[]也是B[]的父类。但是假如给数组加入泛型后，
 * 将无法满足数组协变的原则，因为在运行时无法知道数组的类型。
 */

//1
fun testGenerics() {
    val appleList = ArrayList<Apple>()
    println(appleList.javaClass)

    //Kotlin中的数组是支持泛型的，当然也不再协变，也就是说你不能将任意一个对象数组赋值给Array<Any>或者Array<Any？>。
// 在Kotlin中Any为所有类的父类，
    val appleArray = arrayOfNulls<Apple>(3)
//    val anyArray:Array<Any?> = appleArray //不允许

    //在Kotlin和Java中泛型是通过类型擦除来实现的 ? 主要是为了兼容老版本

    //类型检查是编译器在编译前就会帮我们进行类型检查，所以类型擦除不会影响它。那么类型自动转换又是怎么实现的呢？

}

//2
/**
 * 类型擦除的矛盾
 * 通常情况下使用泛型我们并不在意它的类型是否是类型擦除，但是在有些场景，我们却需要知道运行时泛型参数的类型，
 * 比如序列化/反序列化的时候。这时候我们应该怎么办？通过前面的学习相信你对Java和Kotlin的泛型实现原理已经有了一定的了解
 * ，既然编译后会擦除泛型参数类型，那么我们是不是可以主动指定参数类型来达到运行时获取泛型参数类型的效果呢？
 */

//2. 获取泛型参数类型
open class PlateA<T>(val t: T, val clazz: Class<T>) {
    fun getType() {
        println(clazz)
    }
}

private class AppleA(val weight: Double) {}

//3.使用匿名内部类获取各种类型信息
//为什么使用匿名内部类的这种方式能够在运行时获取泛型参数的类型呢？
// 其实泛型类型擦除并不是真的将全部的类型信息都擦除，
// 还是会将类型信息放在对应class的常量池中的。

fun getClassInfo() {
    val list1 = ArrayList<String>()
    val list2 = object : ArrayList<String>() {} //匿名内部类
    println(list1.javaClass.genericSuperclass)
    println(list2.javaClass.genericSuperclass)
}

//4.Java将泛型信息存储在哪里？
/**
 *既然还存储着相应的类型信息，那么我们就能通过相应的方式来获取这个类型信息。
 * 使用匿名内部类我们就可以实现这种需求。我们着手来设计一个能获取所有类型信息的泛型类：
 */

fun xx() {
    //数组是协变，而List是不变的相关概念，而且用反证法说明了如果在Java支持直接声明泛型数组会出现什么问题。
    // 现在我们用同样的思维来看待这个问题，假如List<String>能赋值给List<Object>会出现什么情况

    //List<String>stringList=newArrayList<String>();
    // List<Object>objList=stringList;//假设可以，编译报错
    // objList.add(Integer(1));
    // Stringstr=stringList.get(0);//将会出错


    //在Java中如果允许List<String>赋值给List<Object>这种行为的话，那么它将会和数组支持泛型一样，
    // 不再保证类型安全，而Java设计师明确泛型最基本的条件就是保证类型安全，所以不支持这种行为。
    // 但是到了Kotlin这里我们发现了一个奇怪的现象

    val stringList: List<String> = ArrayList<String>()
    val anyList: List<Any> = stringList//编译成功

    /**
     * 在Kotlin中竟然能将List<String>赋值给List<Any>，不是说好的Kotlin和Java的泛型原理是一样的吗？
     * 怎么到了Kotlin中就变了？其实我们前面说的都没错，关键在于这两个List并不是同一种类型。我们分别来看一下两种List的定义：
     * public interface List<E> extends Collection<E>{...}
     * public interface List<outE>:Collection<E>{...}
     *
     * 虽然都叫List，也同样支持泛型，但是Kotlin的List定义的泛型参数前面多了一个out关键词，
     * 这个关键词就对这个List的特性起到了很大的作用。普通方式定义的泛型是不变的，简单来说就是不管类型A和类型B是什么关系，
     * Generic<A>与Generic<B>（其中Generic代表泛型类）都没有任何关系。比如，在Java中String是Oject的子类型，
     * 但List<String>并不是List<Object>的子类型，在Kotlin中泛型的原理也是一样的。
     * 但是，Kotlin的List为什么允许List<String>赋值给List<Any>呢？
     */


}


//5.为什么List<String> 不能赋值给List<Object>

open class GenericsToken<T> {
    var type: Type = Any::class.java

    init {
        val superClass = this.javaClass.genericSuperclass
        type = (superClass as ParameterizedType).actualTypeArguments[0]
    }
}

//5.使用内联函数获取泛型信息
/**
 * Kotlin中的内联函数在编译的时候编译器便会将相应函数的字节码插入调用的地方，
 * 也就是说，参数类型也会被插入字节码中，我们就可以获取参数的类型了。
 */

inline fun <reified T> getType(): Class<T> {
    return T::class.java
}


/**
 * 5
 * 使用内联函数获取泛型的参数类型非常简单，只需加上reified关键词即可。这里的意思相当于，
 * 在编译的会将具体的类型插入相应的字节码中，那么我们就能在运行时获取到对应参数的类型了。
 * 所以，我们可以在Kotlin中改进Gson的使用方式：
 *
 * inline fun<reifiedT:Any>Gson.fromJson(json:String):T{//对Gson进行扩展
 *  return Gson().fromJson(json,T::class.java)
 *  }
 *  //使用
 *  val json=...
 *  val stringList=Gson().fromJson<List<String>>(json)
 *
 *  另外需要注意的一点是，Java并不支持主动指定一个函数是否是内联函数，
 *  所以在Kotlin中声明的普通内联函数可以在Java中调用，因为它会被当作一个常规函数；
 *  而用reified来实例化的参数类型的内联函数则不能在Java中调用，因为它永远是需要内联的。
 */

//6.一个支持协变的list
/**
 * 如果在定义的泛型类和泛型方法的泛型参数前面加上out关键词，说明这个泛型类及泛型方法是协变，
 * 简单来说类型A是类型B的子类型，那么Generic<A>也是Generic<B>的子类型，比如在Kotlin中String是Any的子类型，
 * 那么List<String>也是List<Any>的子类型，所以List<String>可以赋值给List<Any>。
 * 但是我们上面说过，如果允许这种行为，将会出现类型不安全的问题。那么Kotlin是如何解决这个问题的？
 */

fun kotlinList() {
    val stringList: List<String> = ArrayList<String>()
//    stringList.add("kotlin")//编译报错，不允许

}

fun main() {
    //1
    testGenerics()

    //2
    val applePlateA = PlateA(AppleA(1.0), AppleA::class.java)
    applePlateA.getType()
    //使用这种方式确实可以达到运行时获取泛型类型参数的效果。但是这种方式也有限制，比如我们就无法获取一个泛型的类型，比如：
//    val listType = ArrayList<String>::class.java //不允许
//       val mapType = Map<String,String>::class.java// 不允许

    //3
    println("------3-------")
    getClassInfo()
    //结果：java.util.AbstractList<E>java.util.ArrayList<java.lang.String>

    //4
    val gt = object : GenericsToken<Map<String, String>>() {}//使用object 创建一个匿名内部类
    println(gt.type)
    //结果java.util.Map<java.lang.String,?extendsjava.lang.String>
    //匿名内部类在初始化的时候就会绑定父类或父接口的相应信息，这样就能通过获取父类或父接口的泛型类型信息来实现我们的需求。
// 你可以利用这样一个类来获取任何泛型的类型，我们常用的Gson也是使用了相同的设计。


}