package com.mic.p14_design

/**
 * 内联函数简化抽象工厂
 */

class Dell(override val cpu: String="dell"): Computer
class Asus(override val cpu: String="asus"): Computer
class Acer(override val cpu: String="acer"): Computer

//abstract class AbstractFactory{
//    abstract fun produce():Computer
//
//    companion object{
//        operator fun  invoke(factory:AbstractFactory):AbstractFactory{
//            return factory
//        }
//    }
//}

//内联函数简化抽象工厂
abstract class AbstractFactory{
    abstract fun produce(): Computer
    companion object{
        inline operator fun<reified T: Computer> invoke(): AbstractFactory =when(T::class){
            Dell::class -> DellFactory()
            Asus::class -> AsusFactory()
            Acer::class -> AcerFactory()
            else->throw IllegalArgumentException()
        }
    }
}

class DellFactory: AbstractFactory() {
    override fun produce()= Dell()
}

class AsusFactory: AbstractFactory(){
    override fun produce()= Asus()
}

class AcerFactory : AbstractFactory(){
    override fun produce()= Acer()
}

fun main(){
//    val dellFactory = AbstractFactory(DellFactory())
//    val dell = dellFactory.produce()
//    println(dell)
    val dellFactory = AbstractFactory<Dell>()
    val dell = dellFactory.produce()
    println(dell)
}