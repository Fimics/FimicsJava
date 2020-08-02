package data.structure.kotlin.stack

import data.structure.kotlin.linkedlist.List
import data.structure.kotlin.arraylist.ArrayList
class Stack<E> {

    private var list :List<E> = ArrayList()

     fun clear(){
        list.clear()
    }

    fun size():Int {
        return list.size()
    }

    fun isEmpty():Boolean{
        return list.isEmpty
    }

    fun push(element:E){
        list.add(element)
    }

    fun pop():E?{
        return list.remove(list.size()-1)
    }

    fun top():E?{
        return list.get(list.size()-1)
    }
}