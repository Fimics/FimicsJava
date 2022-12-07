package water.designpatterns

import kotlin.properties.Delegates

/**
 * 观察者模式
 */
//observable
interface StockUpdateListener{
    fun onRise(price:Int);
    fun onFall(price: Int)
}

class StockDisplay: StockUpdateListener {
    override fun onRise(price: Int) {
        println("The latest stock price has risen to $price")
    }

    override fun onFall(price: Int) {
        println("The latest stock price has fell to $price")
    }
}

class StockUpdate{
    var listeners = mutableSetOf<StockUpdateListener>()

    var price:Int by Delegates.observable(1){_, old, new ->
        listeners.forEach {
            if (new>old) it.onRise(price) else it.onFall(price)
        }
    }

    var value:Int by Delegates.vetoable(0){ property, old, new ->
        when{
            new >100 ->true
            else ->false
        }
    }
}

fun main(){
    val su = StockUpdate()
    val sd = StockDisplay()
    su.listeners.add(sd)
    su.price=100
    su.price=99
}