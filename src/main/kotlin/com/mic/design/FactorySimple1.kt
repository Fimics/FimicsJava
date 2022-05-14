package water.designpatterns

/**
 * 简单工厂  工厂方法
 */

interface Computer{
    val cpu:String

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
    companion object Factory{
        operator fun invoke(type: ComputerType): Computer {
            return when(type){
                ComputerType.PC -> PC()
                ComputerType.Server -> Server()
            }
        }
    }
}


class PC(override val cpu: String="Core"): Computer
class Server(override val cpu: String="Xeon"): Computer

enum class ComputerType{
    PC,Server
}


//简单工厂 (1)
class SimpleFactory {

    fun produce(type: ComputerType): Computer {
         return when(type){
             ComputerType.PC -> PC()
             ComputerType.Server -> Server()
         }
    }
}

//用单例代替工厂类(2)
object ComputerFactory{
    fun produce(type: ComputerType): Computer {
        return when(type){
            ComputerType.PC -> PC()
            ComputerType.Server -> Server()
        }
    }
}

//operator(3)
object ComputerFactory1{
    operator  fun invoke(type: ComputerType): Computer {
        return when(type){
            ComputerType.PC -> PC()
            ComputerType.Server -> Server()
        }
    }
}


//扩展伴生对象方法
fun Computer.Factory.fromCPU(cpu: String): ComputerType? {
    return when(cpu){
        "Core" -> ComputerType.Server
          else->null
    }
}

fun main(){
    val comp = SimpleFactory().produce(ComputerType.Server)
    println(comp)

    val comp1 = ComputerFactory.produce(ComputerType.Server)
    println(comp1)

    //工厂方法
    Computer(ComputerType.PC)
    Computer(ComputerType.Server)

}