package com.mic.p2_function

fun main() {

    val value = test12(4, ::test11)
    println(value)

}

data class Country(val name:String,val continient:String,val population:Int)

class CountryApp{

    fun filterCountries(countries:List<Country>,block:(Country)->Boolean):List<Country>{
        val res = mutableListOf<Country>()
        for (c in countries){
            if (block(c)){
                res.add(c)
            }
        }
        return res
    }

    fun isBigCountry(country: Country):Boolean{
        return country.name!=null
    }
}

private fun test11(age:Int):Int{
    return age*10
}

private fun test12(age1:Int,block: (Int) -> Int):Int{
    return block(age1)
}

private fun test13(count:Int ,block: (Int)->Unit){
    block(count)
}

private fun test14(count:Int,block: () -> Int){
    block()
}

private fun test15(count: Int,block: (Int,String) -> Int){}

private fun test16(age: Int,name: String,block: (bage:Int,bName:String) -> Int){
    block(age,name)
}

private fun test17(age:Int,name: String,block: (Int) -> ((Int)->Int)){

}