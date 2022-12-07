package com.mic.p14_design

/**
 * 简单工厂  工厂方法
 */

interface Computer {
    val cpu: String

    /**
     * 在不指定伴生对象名字的情况下，我们可以直接通过Computer来调用其伴生对象中的方法。
     * 当然，如果你觉得还是Factory这个名字好，那么也没有问题，我们可以用Factory来命名Computer的伴生对象，
     */
    //工厂方法(4)
//    companion object{
//        operator fun invoke(type: ComputerType):Computer{
//            return when(type){
//                ComputerType.PC->PC()
//                ComputerType.Server->Server()
//            }
//        }
//    }

    //指定名字(5)
    companion object Factory {
        operator fun invoke(type: ComputerType): Computer {
            return when (type) {
                ComputerType.PC -> PC()
                ComputerType.Server -> Server()
            }
        }
    }
}


class PC(override val cpu: String = "Core") : Computer
class Server(override val cpu: String = "Xeon") : Computer

enum class ComputerType {
    PC, Server
}

//简单工厂 (1)
class SimpleFactory {

    fun produce(type: ComputerType): Computer {
        return when (type) {
            ComputerType.PC -> PC()
            ComputerType.Server -> Server()
        }
    }
}

//用单例代替工厂类(2)
object ComputerFactory {
    fun produce(type: ComputerType): Computer {
        return when (type) {
            ComputerType.PC -> PC()
            ComputerType.Server -> Server()
        }
    }
}

/**
 * kotlin类默认含有invoke()方法，并且可以通过operator关键字重载，
 * 可以采用原始调用方式：class.invoke(···)；kotlin允许简易调用：class()
 */
//operator(3)
object ComputerFactory1 {
    operator fun invoke(type: ComputerType): Computer {
        return when (type) {
            ComputerType.PC -> PC()
            ComputerType.Server -> Server()
        }
    }
}

//6.扩展伴生对象方法
fun Computer.Factory.fromCPU(cpu: String): ComputerType? {
    return when (cpu) {
        "Core" -> ComputerType.Server
        else -> null
    }
}

fun main() {
    val comp = SimpleFactory().produce(ComputerType.Server)
    println(comp)
    val comp1 = ComputerFactory.produce(ComputerType.Server)
    println(comp1)

    //工厂方法
    Computer(ComputerType.PC)
    Computer(ComputerType.Server)

}