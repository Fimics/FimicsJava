package com.mic.designpatterns

import kotlin.properties.Delegates

sealed class WaterMachineState{

    fun turnHeating(){}
    fun turnColling(){}
    fun turnOff(){}

}

class WaterMachine{
    var state:WaterMachineState  by Delegates.notNull<WaterMachineState>()

    val off = Off(this)
    val heating = Heating(this)

    init {

    }

    fun turnHeating(){
        this.state.turnHeating()
    }
    fun turnColling(){
        this.state.turnColling()
    }
    fun turnOff(){
        this.state.turnOff()
    }
}
