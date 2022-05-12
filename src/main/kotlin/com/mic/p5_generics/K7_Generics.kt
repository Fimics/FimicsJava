package com.mic.p5_generics

// 泛型（generics），表示变量类型的参数化

class MyGenerics<T>(t:T){
    var v :T=t

    init {
        this.v=t
    }
}

fun main(){
    var generics: MyGenerics<String> = MyGenerics("hello generics")
    println(generics.v)
    var g = MyGenerics("hello g")
    println(g.v)
    println(g.v.javaClass)

    println("----------")
    var myG= MyG<String, Number>("abc", 2)
    myTest(myG)

}

// 协变（covariant）与逆变（controvariant）

/*
List<Object>
List<String>

List<String> list = new ArrayList();
List<Object> list2 = list; // 编译失败

list2.add(new Date())

String str = list.get(0);

List<? extends Object> list ...


interface Collection<E> {
void addAll(Collection<E> items);
}

void copyAll(Collection<Object> to, Collection<String> from) {
to.addAll(from);
}

interface Collection<E> {
void addAll(Collection<? extends E> items);
}

协变  上界（covariant）Collection<String>就是Collection<? extends Object>的子类型。

逆变  下界（controvariant）List<? super String> 这里放的只能是字符串以及字符串上层的类型

我们如果只从中读取数据，而不往里面写入内容，那么这样的对象叫做生产者；如果只向里面写入数据，而不从中读取数据，那么这样的数据叫做消费者。

生产者使用? extends E； 消费者使用? super E
 */

/*
 out表示只会读取，不会修改
 in 表示会修改
 */
class MyG<out T,in M>(t :T,m: M){

    private var t:T
    private var m:M

    init {
        this.t=t
        this.m=m
    }

    fun get():T = this.t

    fun set(m:M){
        this.m=m
    }
}

fun myTest(myG: MyG<String, Number>){
    var obj : MyG<Any, Int> = myG
    println(obj.get())
}